package com.youtube.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youtube.domain.Contact;
import com.youtube.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/user/contact_form")
	public String contactForm(Model m) {
		m.addAttribute("command", new Contact());
		return "contact_form";
	}

	@RequestMapping("/user/upd_contact")
	public String editContactForm(Model m, HttpSession session,
			@RequestParam("cid") Integer contactId) {
		session.setAttribute("aContactId", contactId);
		m.addAttribute("command", contactService.findById(contactId));
		return "contact_form";
	}

	@RequestMapping("/user/save_contact")
	public String saveOrupdateContact(@ModelAttribute("command") Contact c,
			Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("aContactId");
		if (contactId == null) {
			// save task
			try {
				Integer userId = (Integer) session.getAttribute("userId");
				c.setUserId(userId); // FK : logged in user id
				contactService.save(c);
				return "redirect:contact_list?act=sv"; // redirect user to
														// contact list url
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to save contact");
				return "contact_form";
			}
		} else {
			// update task
			try {
				c.setContactId(contactId);
				contactService.update(c);
				return "redirect:contact_list?act=ed"; // redirect user to
														// contact list url
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to Edit contact");
				return "contact_form";
			}
		}

	}

	@RequestMapping("/user/contact_list")
	public String contactList(Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId));
		return "contact_list";
	}

	@RequestMapping("/user/del_contact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		contactService.delete(contactId);
		return "redirect:contact_list?act=del";
	}
	
	@RequestMapping("/user/contact_search")
	public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String txt) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId, txt));
		return "contact_list";
	}
	
	@RequestMapping("/user/bulk_cdelete")
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		contactService.delete(contactIds);;
		return "redirect:contact_list?act=del";
	}

}

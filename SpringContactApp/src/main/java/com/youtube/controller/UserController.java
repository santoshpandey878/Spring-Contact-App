package com.youtube.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youtube.command.LoginCommand;
import com.youtube.command.UserCommand;
import com.youtube.domain.User;
import com.youtube.exception.UserBlockedException;
import com.youtube.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"/", "/index"})
	public String index(Model m){
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session){
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if(loggedInUser == null){
				//FAILED
				m.addAttribute("err", "Login failed! Enter valid credentials");
				return "index";
			}
			else {
				//SUCCESS
				// check the role and redirect to perticular dashboard
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)){
					// add user detail in session
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				} else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
					// add user detail in session
					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				} else {
					m.addAttribute("err", "Invalid User Role");
					return "index";
				}
			}
		} catch (UserBlockedException e) {
			// add error message and go back to login form
			m.addAttribute("err", e.getMessage());
			return "index";
		}
		
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index?act=lo";
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard(){
		return "dashboard_user";
	}
	
	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard(){
		return "dashboard_admin";
	}
	
	@RequestMapping(value = "/admin/users")
	public String getUserList(Model m){
		m.addAttribute("users", userService.getUserList());
		return "users";
	}
	
	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m){
		m.addAttribute("command", new UserCommand());
		return "reg_form";
	}
	
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m){
		try {
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg"; // login page
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "Username is already registerd. Please select another username.");
			return "reg_form";
		}
	}
	
	@RequestMapping(value = "/admin/change_status")
	@ResponseBody
	public String changeLoginStatus(@RequestParam("userId") Integer userId, @RequestParam("loginStatus") Integer loginStatus){
		
		try {
			userService.changeLoginStatus(userId, loginStatus);
			return "SUCCESS: Status Changed";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR: Unable to Change Status";
		}
	}
	
	@RequestMapping(value = "/check_avail")
	@ResponseBody
	public String checkAvailability(@RequestParam("username") String username){
		
		try {
			if(userService.isUserNameExist(username)){
				return "This username is already taken. Choose another name";
			}
			else{
				return "Yes! You can take this";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR: Unable to check availabilty";
		}
	}
	
	private void addUserInSession(User u, HttpSession session){
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}
}

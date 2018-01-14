package com.youtube.services;

import java.util.List;

import com.youtube.domain.Contact;

public interface ContactService {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	/*
	 * This method return all user contact (user who is logged in)
	 */
	public List<Contact> findUserContact(Integer userId);
	/*
	 * This method search contact for user(userId) based on given free text criteria(txt)
	 * user who is logged in
	 */
	public List<Contact> findUserContact(Integer userId, String txt);
	
	public Contact findById(Integer contactId);
}

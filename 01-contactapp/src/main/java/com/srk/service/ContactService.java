package com.srk.service;

import java.util.List;

import com.srk.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	public List<Contact> getAllContact();
	public Contact getContactById(Integer contactId);
	public boolean deleteContactById(Integer contactId);
}

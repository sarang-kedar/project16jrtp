package com.srk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srk.entity.Contact;
import com.srk.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		try {
			contact.setActiveSwitch('y');
			contactRepository.save(contact);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact = contactRepository.findById(contactId).orElse(null);
		return contact;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		try {
			contactRepository.deleteById(contactId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

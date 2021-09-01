package com.srk.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

		contact.setActiveSwitch('Y');
		Contact save = contactRepository.save(contact);
		if (save != null && save.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = contactRepository.findAll();
		List<Contact> collect = contacts.stream()
				.filter(contact->contact.getActiveSwitch()=='Y')
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepository.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		/*
		 * boolean status = contactRepository.existsById(contactId); if (status) {
		 * contactRepository.deleteById(contactId); return true; }
		 */
		
		Optional<Contact> optional = contactRepository.findById(contactId);
		if(optional.isPresent()) {
			Contact contact = optional.get();
			contact.setActiveSwitch('N');
			contactRepository.save(contact);
			return true;
		}
		return false;
	}
	
	
}

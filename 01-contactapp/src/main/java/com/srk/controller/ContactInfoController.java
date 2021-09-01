package com.srk.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.srk.entity.Contact;
import com.srk.service.ContactServiceImpl;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactServiceImpl contactService;
	
	@GetMapping("/contact")
	public String showContactForm(Model model) {
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		return "contact-info";
	}
	
	@PostMapping("/savecontact")
	public String savecontact(Contact contact, Model model) {
		boolean isSave=contactService.saveContact(contact);
		if(isSave) {
			model.addAttribute("success", "Contact is saved successfully.");
		}else {
			model.addAttribute("error","Failed to save the contact.");
		}
		return "contact-info";
	}
	
	@GetMapping("/viewcontact")
	public String viewAllContact(Model model) {
		List<Contact> allContact = contactService.getAllContact();
		model.addAttribute("contacts", allContact);
		return "view-all-contact";
	}
}

package com.srk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srk.entity.Contact;
import com.srk.service.ContactService;

@Controller
public class ViewContactController {
	@Autowired
	private ContactService service;
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contact = service.getContactById(contactId);
		model.addAttribute("contact", contact);
		return "contact-info";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model) {
		service.deleteContactById(contactId);
		return "redirect:viewcontact";
	}
}

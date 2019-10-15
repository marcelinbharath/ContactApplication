package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capp.domain.Contact;
import com.capp.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/user/contact_form")
	public String ContactForm(Model m) {
		Contact contact = new Contact();
		m.addAttribute("command", contact);
		return "contact_form";   // JSP form view.
	}
	
	@RequestMapping(value = "/user/edit_contact")
	public String prepareEditForm(HttpSession session, Model m, @RequestParam("cId") Integer contactId) {
		session.setAttribute("aContactId", contactId);
		Contact contact = contactService.findById(contactId);
		m.addAttribute("command", contact);
		return "contact_form";   // JSP form view.
	}
	
	@RequestMapping(value = "/user/save_contact")
	public String saveOrUpdateContact(@ModelAttribute("command") Contact contact, Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("aContactId");
		if (contactId == null) {
			try {
				Integer userId = (Integer) session.getAttribute("userId");
				contact.setUserId(userId);  // FK; looged in user id.
				contactService.save(contact);
				return "redirect:clist?act=sv";   // Redirect user to contact listing 
			} catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to Save contact.");
				return "contact_form";
			}
		}else {
			// update contct
			try {
				contact.setContactId(contactId);
				contactService.update(contact);
				return "redirect:clist?act=ed";   // Redirect user to contact listing 
			} catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to Edit contact.");
				return "contact_form";
			}
		}
	}
	
	@RequestMapping(value = "/user/clist")
	public String contactList(Model m, HttpSession session) {
		int userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId));		
		return "clist";   // JSP
	}
	
	@RequestMapping(value = "/user/contact_search")
	public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
		int userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId, freeText));		
		return "clist";   // JSP
	}
	
	@RequestMapping(value = "/user/del_contact")
	public String deleteContact(@RequestParam("cId") Integer contactId) {
		contactService.delete(contactId);
		return "redirect:clist?act=del";   // JSP
	}
	
	@RequestMapping(value = "/user/bulk_cdelete")
	public String deleteBulkDelete(@RequestParam("cId") Integer[] contactIds) {
		contactService.delete(contactIds);
		return "redirect:clist?act=del";   // JSP
	}
}

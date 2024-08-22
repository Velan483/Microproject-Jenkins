package com.velan.restapp.service;

import java.util.List;
import com.velan.restapp.model.ContactPage;

public interface ContactService {

	public void addContact(ContactPage contact);
	public List<ContactPage> getAllContactPages();
	public void deleteContactPage(int id);

}

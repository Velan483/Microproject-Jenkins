package com.velan.restapp.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.ContactPage;
import com.velan.restapp.repository.ContactRepo;
import com.velan.restapp.service.ContactService;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	ContactRepo repo;

	@Override
	public void addContact(ContactPage contact) {
		repo.add(contact);
	}

	@Override
	public List<ContactPage> getAllContactPages() {
		return repo.findAllContactPages();
	}
	
	@Override
	public void deleteContactPage(int id) {
		repo.delete(id);
	}

}

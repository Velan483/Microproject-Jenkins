package com.velan.restapp.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.ContactPage;

@Repository
public interface ContactRepo{

	public void add(ContactPage contact);
	public List<ContactPage> findAllContactPages();
	public void delete(int id);
}

package com.velan.restapp.repositoryimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.velan.restapp.model.ContactPage;
import com.velan.restapp.repository.ContactRepo;

@Repository
@Transactional
public class ContactRepoImp implements ContactRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(ContactPage contact) {
		em.persist(contact);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactPage> findAllContactPages() {
		String hql = "from ContactPage";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public void delete(int id) {
		ContactPage contact = em.find(ContactPage.class, id);
		em.remove(contact);
	}

}

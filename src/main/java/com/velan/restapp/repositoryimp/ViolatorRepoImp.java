package com.velan.restapp.repositoryimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.velan.restapp.model.Violator;
import com.velan.restapp.repository.ViolatorRepo;

@Repository
@Transactional
public class ViolatorRepoImp implements ViolatorRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Violator violator) {
		em.persist(violator);
	}
	
	@Override
	public Optional<Violator> findByEmailAndPassword(String email, String password) {
		TypedQuery<Violator> query = em.createQuery(
				"SELECT u FROM Violator u WHERE u.email = :email AND u.password = :password", Violator.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Violator violator = query.getResultStream().findFirst().orElse(null);
		return Optional.ofNullable(violator);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Violator> findAllViolators() {
		String hql = "from Violator";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIdList() {
		String hql="select violator_id from Violator";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Violator findById(int id) {
		return em.find(Violator.class, id);
	}

	@Override
	public void update(Violator violator) {
		em.merge(violator);
	}

	@Override
	public void delete(int id) {
		Violator violator = em.find(Violator.class, id);
		em.remove(violator);
	}

}

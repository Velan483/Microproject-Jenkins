package com.velan.restapp.repositoryimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.TrafficOfficer;
import com.velan.restapp.repository.TrafficOfficerRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrafficOfficerRepoImp implements TrafficOfficerRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(TrafficOfficer officer) {
		em.persist(officer);
	}
	
	@Override
	public Optional<TrafficOfficer> findByEmailAndPassword(String email, String password) {
		TypedQuery<TrafficOfficer> query = em.createQuery(
				"SELECT u FROM TrafficOfficer u WHERE u.email = :email AND u.password = :password", TrafficOfficer.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		TrafficOfficer officer = query.getResultStream().findFirst().orElse(null);
		return Optional.ofNullable(officer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrafficOfficer> findAllTrafficOfficers() {
		String hql = "from TrafficOfficer";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIdList() {
		String hql="select officer_id from TrafficOfficer";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public TrafficOfficer findById(int id) {
		return em.find(TrafficOfficer.class, id);
	}

	@Override
	public void update(TrafficOfficer officer) {
		em.merge(officer);
	}

	@Override
	public void delete(int id) {
		TrafficOfficer officer = em.find(TrafficOfficer.class, id);
		em.remove(officer);
	}

}

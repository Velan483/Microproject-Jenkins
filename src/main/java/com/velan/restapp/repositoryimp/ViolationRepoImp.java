package com.velan.restapp.repositoryimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.velan.restapp.model.Violation;
import com.velan.restapp.repository.ViolationRepo;

@Repository
@Transactional
public class ViolationRepoImp implements ViolationRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Violation violation) {
		em.persist(violation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Violation> findAllViolations() {
		String hql = "from Violation";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIdList() {
		String hql="select violation_id from Violation";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Violation findById(int id) {
		return em.find(Violation.class, id);
	}

	@Override
	public void update(Violation violation) {
		em.merge(violation);
	}

	@Override
	public void delete(int id) {
		Violation violation = em.find(Violation.class, id);
		em.remove(violation);
	}

}

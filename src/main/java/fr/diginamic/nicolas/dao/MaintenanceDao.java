package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Maintenance;

public class MaintenanceDao extends AbstractDao {

	public static List<Maintenance> findAll() {
		TypedQuery<Maintenance> query = em.createQuery("SELECT m FROM Maintenance m ORDER BY m.dateDebut ASC", Maintenance.class);
		return query.getResultList();
	}
	
	public static Maintenance findById(Long id) {
		return em.find(Maintenance.class, id);
	}

	public static Maintenance create(Maintenance m) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(m);
		transaction.commit();
		return m;
	}

	public static void update(Maintenance m) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(m);
		transaction.commit();
	}

	public static void delete(Maintenance m) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(m);
		transaction.commit();
	}
}

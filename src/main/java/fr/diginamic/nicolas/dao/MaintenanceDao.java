package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Maintenance;

public class MaintenanceDao extends AbstractDao {

	public static List<Maintenance> findAll() {
		TypedQuery<Maintenance> query = em.createQuery("SELECT m FROM Maintenance m ORDER BY m.id ASC", Maintenance.class);
		return query.getResultList();
	}
	
	public static List<Maintenance> findAllByVehicule(Long id) {
		TypedQuery<Maintenance> query = em.createQuery("SELECT m FROM Maintenance m WHERE m.vehicule.id=?1", Maintenance.class);
		query.setParameter(1, id);
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
		transaction.commit();
	}

	public static void delete(Maintenance m) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(m);
		transaction.commit();
	}
}

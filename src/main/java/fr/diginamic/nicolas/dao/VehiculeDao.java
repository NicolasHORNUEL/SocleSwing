package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Vehicule;

public class VehiculeDao extends AbstractDao {

	public static List<Vehicule> findAll() {
		TypedQuery<Vehicule> query = em.createQuery("SELECT v FROM Vehicule v", Vehicule.class);
		return query.getResultList();
	}

	public static Vehicule findById(Long id) {
		return em.find(Vehicule.class, id);
	}

	public static Boolean exist(Vehicule v) {
		String immat = v.getImmatriculation();
		TypedQuery<Vehicule> query = em.createQuery("SELECT v FROM Vehicule v WHERE v.immatriculation=?1", Vehicule.class);
		query.setParameter(1, immat);
		List<Vehicule> vehicules = query.getResultList();
		if (vehicules.isEmpty()) {
			return false;
		}
		return true;
	}

	public static Vehicule create(Vehicule v) {
		if (!exist(v)) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(v);
			transaction.commit();
		}
		return v;
	}

	public static void update(Vehicule v) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(v);
		transaction.commit();
	}

	public static void delete(Vehicule v) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(v);
		transaction.commit();
	}

}

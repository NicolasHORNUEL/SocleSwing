package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.Application;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.entite.Voiture;

public class VoitureDao {

	private static EntityManager em = Application.emf.createEntityManager();

	public static List<Voiture> findAll() {
		TypedQuery<Voiture> query = em.createQuery("SELECT v FROM Voiture cv", Voiture.class);
		return query.getResultList();
	}

	public static Voiture findById(Long id) {
		return em.find(Voiture.class, id);
	}

	public static Boolean exist(Voiture v) {
		String immat = v.getImmatriculation();
		TypedQuery<Vehicule> query = em.createQuery("SELECT v FROM Vehicule v WHERE v.immatriculation=?1", Vehicule.class);
		query.setParameter(1, immat);
		List<Vehicule> vehicules = query.getResultList();
		if (vehicules.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static Voiture create(Voiture v) {
		if (!exist(v)) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(v);
			transaction.commit();
		}
		return v;
	}
	
	public static void update(Voiture v) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(v);
		transaction.commit();
	}

	public static void delete(Voiture v) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(v);
		transaction.commit();
	}
}

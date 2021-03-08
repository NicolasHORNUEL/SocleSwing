package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.Application;
import fr.diginamic.nicolas.entite.Camion;
import fr.diginamic.nicolas.entite.Vehicule;

public class CamionDao {
	
	private static EntityManager em = Application.emf.createEntityManager();

	public static List<Camion> findAll() {
		TypedQuery<Camion> query = em.createQuery("SELECT c FROM Camion c", Camion.class);
		return query.getResultList();
	}

	public static Camion findById(Long id) {
		return em.find(Camion.class, id);
	}
	
	public static Boolean exist(Camion c) {
		String immat = c.getImmatriculation();
		TypedQuery<Vehicule> query = em.createQuery("SELECT v FROM Vehicule v WHERE v.immatriculation=?1", Vehicule.class);
		query.setParameter(1, immat);
		List<Vehicule> vehicules = query.getResultList();
		if (vehicules.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static Camion create(Camion c) {
		if (!exist(c)) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(c);
			transaction.commit();
		}
		return c;
	}
	
	public static void update(Camion c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(c);
		transaction.commit();
	}

	public static void delete(Camion c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(c);
		transaction.commit();
	}

}
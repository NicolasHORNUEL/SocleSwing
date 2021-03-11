package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Agence;

public class AgenceDao  extends AbstractDao {
	
	public static List<Agence> findAll() {
		TypedQuery<Agence> query = em.createQuery("SELECT r FROM Agence r", Agence.class);
		return query.getResultList();
	}

	public static Agence findById(Long id) {
		return em.find(Agence.class, id);
	}

	public static Agence create(Agence a) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(a);
		transaction.commit();
		return a;
	}

	public static void update(Agence a) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		transaction.commit();
	}

	public static void delete(Agence a) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(a);
		transaction.commit();
	}

}

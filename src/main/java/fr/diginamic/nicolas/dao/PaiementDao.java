package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.Application;
import fr.diginamic.nicolas.entite.Facture;
import fr.diginamic.nicolas.entite.Paiement;

public class PaiementDao {

	private static EntityManager em = Application.emf.createEntityManager();

	public static Paiement create(Paiement p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
		return p;
	}

}

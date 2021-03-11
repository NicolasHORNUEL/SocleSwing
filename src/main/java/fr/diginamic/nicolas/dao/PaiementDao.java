package fr.diginamic.nicolas.dao;

import javax.persistence.EntityTransaction;

import fr.diginamic.nicolas.entite.Paiement;

public class PaiementDao extends AbstractDao {


	public static Paiement create(Paiement p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
		return p;
	}

}

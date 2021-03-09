package fr.diginamic.nicolas.dao;

import javax.persistence.EntityTransaction;

import fr.diginamic.nicolas.entite.Agence;
import fr.diginamic.nicolas.entite.Facture;
import fr.diginamic.nicolas.entite.Paiement;

public class PaiementDao extends AbstractDao {


	public static Paiement create(Paiement p) {
		Agence a = p.getAgence();
		Facture f = p.getFacture();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		em.persist(a);
		em.persist(f);
		transaction.commit();
		return p;
	}

}

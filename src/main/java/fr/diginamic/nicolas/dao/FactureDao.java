package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Facture;

public class FactureDao extends AbstractDao {

	public static Facture findByResa(Long id) {
		TypedQuery<Facture> query = em.createQuery("SELECT f FROM Facture f WHERE f.reservation.id=?1", Facture.class);
		query.setParameter(1, id);
		return query.getResultList().get(0);
	}
	
	public static boolean exist(Facture f) {
		TypedQuery<Facture> query = em.createQuery("SELECT f FROM Facture f WHERE f.numeroFacture=?1", Facture.class);
		query.setParameter(1, f.getNumeroFacture());
		List<Facture> factures = query.getResultList();
		if (factures.isEmpty()) {
			return false;
		}
		return true;
	}

	public static Facture create(Facture f) {
		if (!exist(f)) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(f);
			transaction.commit();
		}
		return f;
	}

}

package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Client;

public class ClientDao extends AbstractDao {

	public static List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		return query.getResultList();
	}

	public static Client findById(Long id) {
		return em.find(Client.class, id);
	}

	public static boolean exist(Client c) {
		String email = c.getAdresse().getEmail();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c JOIN c.adresse a WHERE a.email=?1", Client.class);
		query.setParameter(1, email);
		List<Client> clients = query.getResultList();
		if (clients.isEmpty()) {
			return false;
		}
		return true;
	}

	public static Client create(Client c) {
		if (!exist(c)) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(c);
			transaction.commit();
		}
		return c;
	}

	public static void update(Client c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(c);
		transaction.commit();
	}

	public static void delete(Client c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(c);
		transaction.commit();
	}

}

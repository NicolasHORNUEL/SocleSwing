package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Reservation;

public class ReservationDao extends AbstractDao {

	public static List<Reservation> findAll() {
		TypedQuery<Reservation> query = em.createQuery("SELECT r FROM Reservation r", Reservation.class);
		return query.getResultList();
	}

	public static Reservation findById(Long id) {
		return em.find(Reservation.class, id);
	}

	public static Reservation create(Reservation r) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(r);
		transaction.commit();
		return r;
	}

	public static void update(Reservation r) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(r);
		transaction.commit();
	}

	public static void delete(Reservation r) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(r);
		transaction.commit();
	}

}

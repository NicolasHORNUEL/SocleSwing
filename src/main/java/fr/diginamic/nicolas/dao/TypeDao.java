package fr.diginamic.nicolas.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.nicolas.entite.Type;
import fr.diginamic.nicolas.enumeration.TypeVehicule;

public class TypeDao  extends AbstractDao {
	
	public static List<Type> findAll() {
		TypedQuery<Type> query = em.createQuery("SELECT t FROM Type t", Type.class);
		return query.getResultList();
	}

	public static Type findById(Long id) {
		return em.find(Type.class, id);
	}
	
	public static Type findOne(TypeVehicule typeVehicule) {
		TypedQuery<Type> query = em.createQuery("SELECT t FROM Type t WHERE t.typeVehicule=?1", Type.class);
		query.setParameter(1, typeVehicule);
		return query.getResultList().get(0);
	}

	public static Boolean exist(Type t) {
		TypeVehicule typeVehicule = t.getTypeVehicule();
		TypedQuery<Type> query = em.createQuery("SELECT t FROM Type t WHERE t.typeVehicule=?1", Type.class);
		query.setParameter(1, typeVehicule);
		List<Type> types = query.getResultList();
		if (types.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static Type create(Type t) {
		if (!exist(t)) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(t);
			transaction.commit();
		}
		return t;
	}
	
	public static void update(Type t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(t);
		transaction.commit();
	}

	public static void delete(Type t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(t);
		transaction.commit();
	}
}

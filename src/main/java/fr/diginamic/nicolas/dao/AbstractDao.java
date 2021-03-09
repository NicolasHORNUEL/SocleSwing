package fr.diginamic.nicolas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("agence-vip-location");

	protected static EntityManager em = emf.createEntityManager();
}

package com.arijit.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arijit.model.User;

@Repository
public class UserRepository {
	
	@PersistenceUnit(unitName = "techblog")
	 private EntityManagerFactory emf;
	
	public void registerUser(User newUser) {
		   EntityManager em = emf.createEntityManager();
		   EntityTransaction transaction = em.getTransaction();

		   try {
		       transaction.begin();
		       em.persist(newUser);
		       transaction.commit();
		   }catch(Exception e) {
		       transaction.rollback();
		   }
		}

}

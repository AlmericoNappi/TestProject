package com.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.JpaUtil;
import com.dao.DipendentiDao;
import com.model.Dipendenti;

public class DipendentiDaoImpl implements DipendentiDao {

	public void save(Dipendenti d) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			String hash = crypto(d.getPassword());
			d.setPassword(hash);
			em.persist(d);

			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			em.close();
		}
	}

	public boolean login(String user, String pwd) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		Query q = em.createQuery("SELECT c FROM Dipendenti c WHERE c.username = :user")
				.setParameter("user", user);
		try {
			Dipendenti res = (Dipendenti) q.getSingleResult();
			
			if(BCrypt.checkpw(pwd, res.getPassword()))
				return true;
			else
				return false;
		} catch (NoResultException e) {
			return false;
		}

	}
	
	private String crypto(String pwd) {
		String hash = BCrypt.hashpw(pwd, BCrypt.gensalt());
		return hash;
	}

}

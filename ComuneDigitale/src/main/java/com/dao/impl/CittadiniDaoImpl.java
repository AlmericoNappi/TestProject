package com.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.JpaUtil;
import com.dao.CittadiniDao;
import com.model.Cittadini;

public class CittadiniDaoImpl implements CittadiniDao {

	public void save(Cittadini c) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(c);

			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			em.close();
		}

	}

	public void update(Cittadini c) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.merge(c);

			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			em.close();
		}
	}

	public void delete(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(em.find(Cittadini.class, id));

			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			em.close();
		}
		
		
	}
	/**
	 *  Ricerca del cittadino per codice fiscale
	 * 
	 *  @author Antonio Pagano
	 *  @param codFisc codice fiscale da ricercare 
	 *  @return Cittadino con quel codice fiscale
	 */

	
	public Cittadini findByCodiceFiscale(String codFisc) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		Query q = em.createQuery("SELECT c FROM Cittadini c WHERE c.codiceFiscale = :codFisc")
				.setParameter("codFisc", codFisc);
		try {
			Cittadini res = (Cittadini) q.getSingleResult();
			
			return res;
		} catch (NoResultException e) {
			return null;
		}
		
	}

}

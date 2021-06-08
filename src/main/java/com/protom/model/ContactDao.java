package com.protom.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.protom.model.entities.Contact;
import com.protom.model.util.DBUtil;


public class ContactDao {

	public static Contact getContact(Integer id) {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		return em.find(Contact.class, id);
	}

	public static void insert(Contact c) {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(c);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Contact c) {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(c);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}


	public static void delete(Contact c) {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			c = em.find(Contact.class, c.getId());  
			em.remove(c);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Contact> findByName(String name) {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		String qString = "Select c from Contact c where c.name=:name";
		TypedQuery<Contact> q = em.createQuery(qString, Contact.class);
		q.setParameter("name", name);
		List<Contact> contacts = null;
		try {
			contacts = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return contacts;
	}
	
	public static List<Contact> findAll() {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		String qString = "Select c from Contact c JOIN c.phones p";
		TypedQuery<Contact> q = em.createQuery(qString, Contact.class);
		List<Contact> contacts = null;
		try {
			contacts = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return contacts;
	}
	
	public static List<Contact> findAllNamedQuery() {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
	}
	
	
	public static List<Contact> findAllCriteria() {
		EntityManager em = DBUtil.getEntityManager(DBUtil.RUBRICA_WEB_PU);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contact> c = cb.createQuery(Contact.class);
		Root<Contact> cont = c.from(Contact.class);
		cont.fetch("phones", JoinType.LEFT);
		cont.fetch("emails", JoinType.LEFT);
		c.select(cont).distinct(true);
		TypedQuery<Contact> q = em.createQuery(c);
		return q.getResultList();
	}
}

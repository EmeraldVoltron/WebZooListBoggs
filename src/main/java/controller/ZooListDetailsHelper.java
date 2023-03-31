package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ZooListDetails;

public class ZooListDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebZooListBoggs");

	public void insertNewZooListDetails(ZooListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ZooListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<ZooListDetails> allDetails = em.createQuery("SELECT z FROM ZooListDetails z").getResultList();
		return allDetails;
	}

	public ZooListDetails searchForListDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ZooListDetails found = em.find(ZooListDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteList(ZooListDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooListDetails> typedQuery = em.createQuery("SELECT detail from ZooListDetails detail where detail.id= :selectedId", ZooListDetails.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		ZooListDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateList(ZooListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}

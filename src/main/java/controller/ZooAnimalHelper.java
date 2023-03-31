/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 23, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ZooAnimals;

/**
 * @author abbyb
 *
 */
public class ZooAnimalHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebZooListBoggs");
	
	public void insertAnimal(ZooAnimals za) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(za);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ZooAnimals> showAllAnimals(){
		EntityManager em = emfactory.createEntityManager();
		List<ZooAnimals> allAnimals = em.createQuery("SELECT i FROM ZooAnimals i").getResultList();
		return allAnimals;
	}

	public void deleteAnimal(ZooAnimals toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimals> typedQuery = em.createQuery("select za from ZooAnimals za where za.species = :selectedSpecies and za.name = :selectedName", ZooAnimals.class);
		
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		ZooAnimals result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ZooAnimals> searchForAnimalBySpecies(String species){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimals> typedQuery = em.createQuery("Select za from ZooAnimals za where za.species = :selectedSpecies", ZooAnimals.class);
		
		typedQuery.setParameter("selectedSpecies", species);
		List<ZooAnimals> foundAnimals = typedQuery.getResultList();
		em.close();
		
		return foundAnimals;
	}
	
	public List<ZooAnimals> searchForAnimalByName(String name){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimals> typedQuery = em.createQuery("select za from ZooAnimals za where za.name = :selectedName", ZooAnimals.class);
		
		List<ZooAnimals> foundAnimals = typedQuery.getResultList();
		em.close();
		return foundAnimals;
	}
	
	public ZooAnimals searchForAnimalById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ZooAnimals found = em.find(ZooAnimals.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateAnimal(ZooAnimals toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}

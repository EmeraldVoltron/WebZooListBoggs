/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 22, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abbyb
 *
 */
@Entity
@Table(name="animals")
public class ZooAnimals {
	@Id
 	@GeneratedValue
 	@Column(name="ID")
 	private int id;
 	@Column(name="SPECIES")
 	private String species;
 	@Column(name="NAME")
 	private String name;
 	
 	//TO-DO getters/setters, constructors, to strings
 	public ZooAnimals(){
 	}
 	
 	public ZooAnimals(String species, String name) {
 		this.species = species;
 		this.name = name;
 	}
 	
 	public String returnAnimalDetails() {
 		return this.species + ": " + this.name;
 	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

 	
}

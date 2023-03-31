/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 22, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author abbyb
 *
 */
@Entity
public class ZooListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate lastShift;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private ZooKeeper zooKeeper;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ZooAnimals> listOfAnimals;

	
	public ZooListDetails() {
		super();
	}
	
	public ZooListDetails(int id, String listName, LocalDate lastShift, ZooKeeper zooKeeper, List<ZooAnimals> listOfAnimals) {
		super();
		this.id = id;
		this.listName = listName;
		this.lastShift = lastShift;
		this.zooKeeper = zooKeeper;
		this.listOfAnimals = listOfAnimals;
	}
	
	public ZooListDetails(String listName, LocalDate lastShift, ZooKeeper zooKeeper, List<ZooAnimals> listOfAnimals) {
		super();
		this.listName = listName;
		this.lastShift = lastShift;
		this.zooKeeper = zooKeeper;
		this.listOfAnimals = listOfAnimals;
	}
	
	public ZooListDetails(String listName, LocalDate lastShift, ZooKeeper zooKeeper) {
		super();
		this.listName = listName;
		this.lastShift = lastShift;
		this.zooKeeper = zooKeeper;
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
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	

	/**
	 * @return the lastShift
	 */
	public LocalDate getLastShift() {
		return lastShift;
	}

	/**
	 * @param lastShift the lastShift to set
	 */
	public void setLastShift(LocalDate lastShift) {
		this.lastShift = lastShift;
	}

	/**
	 * @return the zooKeeper
	 */
	public ZooKeeper getZooKeeper() {
		return zooKeeper;
	}

	/**
	 * @param zooKeeper the zooKeeper to set
	 */
	public void setZooKeeper(ZooKeeper zooKeeper) {
		this.zooKeeper = zooKeeper;
	}

	/**
	 * @return the listOfAnimals
	 */
	public List<ZooAnimals> getListOfAnimals() {
		return listOfAnimals;
	}

	/**
	 * @param listOfAnimals the listOfAnimals to set
	 */
	public void setListOfAnimals(List<ZooAnimals> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
	}

	@Override
	public String toString() {
		return "ZooListDetails [id=" + id + ", listName=" + listName + ", lastShift=" + lastShift + ", zooKeeper="
				+ zooKeeper + ", listOfAnimals=" + listOfAnimals + "]";
	}

	
	
	
}

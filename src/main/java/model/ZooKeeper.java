/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 22, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abbyb
 *
 */
@Entity
@Table(name="zookeeper")
public class ZooKeeper {
	@Id
	@GeneratedValue
	private int id;
	private String keeperName;
	
	public ZooKeeper() {
		super();
	}
	
	public ZooKeeper(int id, String keeperName) {
		super();
		this.id = id;
		this.keeperName = keeperName;
	}
	
	public ZooKeeper(String keeperName) {
		super();
		this.keeperName = keeperName;
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
	 * @return the keeperName
	 */
	public String getKeeperName() {
		return keeperName;
	}

	/**
	 * @param keeperName the keeperName to set
	 */
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}

	@Override
	public String toString() {
		return "ZooKeeper [id=" + id + ", keeperName=" + keeperName + "]";
	}

}

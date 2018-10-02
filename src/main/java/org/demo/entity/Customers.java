package org.demo.entity;
// Generated Oct 1, 2018 4:13:35 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customers generated by hbm2java
 */
@Entity
public class Customers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String customerName;
	private String customerAddress;
	private String otherDetails;
	private Set<Contacts> contactses = new HashSet<Contacts>(0);

	public Customers() {
	}

	public Customers(String customerName, String customerAddress, String otherDetails, Set<Contacts> contactses) {
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.otherDetails = otherDetails;
		this.contactses = contactses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Customer_ID", unique = true, nullable = false)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "Customer_Name")
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "Customer_Address", length = 45)
	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Column(name = "Other_Details", length = 45)
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	public Set<Contacts> getContactses() {
		return this.contactses;
	}

	public void setContactses(Set<Contacts> contactses) {
		this.contactses = contactses;
	}

}

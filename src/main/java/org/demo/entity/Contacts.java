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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Contacts generated by hbm2java
 */
@Entity
public class Contacts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer contactId;
	private Customers customers;
	private String contactName;
	private String jobTitle;
	private String contactDetails;
	private Set<ServiceRequestCalls> serviceRequestCallses = new HashSet<ServiceRequestCalls>(0);

	public Contacts() {
	}

	public Contacts(Customers customers) {
		this.customers = customers;
	}

	public Contacts(Customers customers, String contactName, String jobTitle, String contactDetails,
			Set<ServiceRequestCalls> serviceRequestCallses) {
		this.customers = customers;
		this.contactName = contactName;
		this.jobTitle = jobTitle;
		this.contactDetails = contactDetails;
		this.serviceRequestCallses = serviceRequestCallses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Contact_ID", unique = true, nullable = false)
	public Integer getContactId() {
		return this.contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customers_Customer_ID", nullable = false)
	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@Column(name = "Contact_Name", length = 45)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "Job_Title", length = 45)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "Contact_Details", length = 45)
	public String getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
	public Set<ServiceRequestCalls> getServiceRequestCallses() {
		return this.serviceRequestCallses;
	}

	public void setServiceRequestCallses(Set<ServiceRequestCalls> serviceRequestCallses) {
		this.serviceRequestCallses = serviceRequestCallses;
	}

}

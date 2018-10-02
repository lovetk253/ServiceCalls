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
 * OutcomeCodes generated by hbm2java
 */
@Entity
public class OutcomeCodes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer outcomeCodes;
	private String outcomeDescription;
	private Set<ServiceRequestActions> serviceRequestActionses = new HashSet<ServiceRequestActions>(0);

	public OutcomeCodes() {
	}

	public OutcomeCodes(String outcomeDescription, Set<ServiceRequestActions> serviceRequestActionses) {
		this.outcomeDescription = outcomeDescription;
		this.serviceRequestActionses = serviceRequestActionses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Outcome_Codes", unique = true, nullable = false)
	public Integer getOutcomeCodes() {
		return this.outcomeCodes;
	}

	public void setOutcomeCodes(Integer outcomeCodes) {
		this.outcomeCodes = outcomeCodes;
	}

	@Column(name = "Outcome_Description", length = 45)
	public String getOutcomeDescription() {
		return this.outcomeDescription;
	}

	public void setOutcomeDescription(String outcomeDescription) {
		this.outcomeDescription = outcomeDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outcomeCodes")
	public Set<ServiceRequestActions> getServiceRequestActionses() {
		return this.serviceRequestActionses;
	}

	public void setServiceRequestActionses(Set<ServiceRequestActions> serviceRequestActionses) {
		this.serviceRequestActionses = serviceRequestActionses;
	}

}

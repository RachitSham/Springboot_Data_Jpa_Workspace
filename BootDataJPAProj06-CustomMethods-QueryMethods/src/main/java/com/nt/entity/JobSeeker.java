package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JOB_SEEKER_INFO")
@Data
@NoArgsConstructor
public class JobSeeker {

	@Id
	@Column(name = "JS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jsId;

	@Column(name = "JS_NAME", length = 25)
	private String jsName;

	@Column(name = "JS_QLFY", length = 25)
	private String qlfy;

	@Column(name = "JS_PERCENTAGE")
	private Double percentage;

	@Column(name = "JS_CONTACT_INFO")
	private Long mobileNo;

	// Manually define the required constructor (excluding ID)
	public JobSeeker(String jsName, String qlfy, Double percentage, Long mobileNo) {
		this.jsName = jsName;
		this.qlfy = qlfy;
		this.percentage = percentage;
		this.mobileNo = mobileNo;
	}
}

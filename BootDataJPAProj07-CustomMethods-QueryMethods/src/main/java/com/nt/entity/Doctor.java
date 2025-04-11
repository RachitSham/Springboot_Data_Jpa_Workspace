package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "JPA_DOCTOR_INFO")
//@SequenceGenerator(name = "gen1", sequenceName = "doctor_sequence", initialValue = 100, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Doctor {

	@Column(name = "DOC_ID")
	@Id
	//@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer docId;

	@Column(name = "DOC_NAME", length = 50)
	@NonNull
	private String docName;

	@Column(name = "SPECIALIZATION", length = 50)
	@NonNull
	private String specialization;

	@Column(name = "INCOME")
	@NonNull
	// @Transient
	private double income;

}

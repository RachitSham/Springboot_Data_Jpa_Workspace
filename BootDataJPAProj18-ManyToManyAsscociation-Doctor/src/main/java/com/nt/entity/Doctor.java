package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_MTOM_DOCTOR")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer did;

	@Column(length = 30)
	private String dname;

	@Column(length = 30)
	private String specialization;

	@ManyToMany(targetEntity = Patient.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "JPA_MTOM_DOCTOR_PATIENT", // third table
			joinColumns = @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "DID"), // owning side FK Column
			inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PID")) // owning side FK
																									// Column
	private List<Patient> patients;

	// toString
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", specialization=" + specialization + "]";
	}

}

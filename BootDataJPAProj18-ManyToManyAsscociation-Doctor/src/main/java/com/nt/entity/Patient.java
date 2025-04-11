package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_MTOM_PATIENT")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Patient {

	@Id
	@SequenceGenerator(name = "PAT_Gen1", sequenceName = "PATIENT_SEQ", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "PAT_Gen1", strategy = GenerationType.SEQUENCE)
	private Integer pid;

	@Column(length = 30)
	private String pname;

	@Column(length = 30)
	private String problem;

	@ManyToMany(targetEntity = Doctor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
	private List<Doctor> doctors;

	// toString
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", problem=" + problem + "]";
	}

}

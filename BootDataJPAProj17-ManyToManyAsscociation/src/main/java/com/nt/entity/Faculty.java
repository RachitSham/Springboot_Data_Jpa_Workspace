package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_MTOM_FACULTY")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Faculty {

	@Id
	@SequenceGenerator(name = "Gen1", sequenceName = "FID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "Gen1", strategy = GenerationType.SEQUENCE)
	private Integer fid;

	@Column(length = 30)
	@NonNull
	private String fname;

	@Column(length = 30)
	@NonNull
	private String faddrs;

	@ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "JPA_MTOM_FACULTYS_STUDENTS", // Third Table
			joinColumns = @JoinColumn(name = "faculty_id", referencedColumnName = "fid"), // owning side FK Column
			inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "sid")) // owning side FK Column
	private Set<Student> studentInfo = new HashSet<Student>();

	// toString
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", faddrs=" + faddrs + "]";
	}

}

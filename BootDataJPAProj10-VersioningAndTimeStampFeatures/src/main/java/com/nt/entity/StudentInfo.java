package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "STUDENT_INFO")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;

	@Column(name = "STUDENT_NAME")
	@NonNull
	private String sname;
	
	@Column(name = "COURSE_NAME")
	@NonNull
	private String cName;
	
	@Column(name = "STUDENT_EMAIL")
	@NonNull
	private String sEmail;
	
	@Column(name = "STUDENT_MOBILE_NO")
	@NonNull
	private Long sMobileNo;
	
	// for Versioning Feature 
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer UpdateCount;
	
	// For Time Stamping Features 
	@Column(name = "COURSE_OPTED_ON", insertable = true )
	@CreationTimestamp
	private LocalDateTime courseOptedOn;
	
	// For Time Stamping Features 
	@Column(name = "LASTLY_COURSE_UPDATED_ON", insertable = false)
	@UpdateTimestamp
	private LocalDateTime lastlyCourseUpdatedOn;
}

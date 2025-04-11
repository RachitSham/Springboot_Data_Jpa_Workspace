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
@Table(name = "CALLER_TUNE_INFO")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CallerTuneInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tuneID;

	@Column(length = 25)
	@NonNull
	private String tuneName;

	@Column(length = 20)
	@NonNull
	private String movieName;

	// For Versioning Feature
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer updateCount;

	// For time stamping Feature
	@Column(name = "SERVICE_OPTED_ON", insertable = true)
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	
	// For time stamping Features
	@Column(name = "LASTLY_UPDATED_ON", insertable = false)
	@UpdateTimestamp
	private LocalDateTime lastlyUpdatedOn;
}

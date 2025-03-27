package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "JPA_SINGER_INFO")
//@SequenceGenerator(name = "singer_gen1 ", sequenceName = "singer_sequence", initialValue = 111, allocationSize = 1)
@Data
public class Singer {

	@Id
	@Column(name = "SINGER_ID")
	// there is no support for sequences in MYSQL
	// @GeneratedValue(generator = "singer_gen1",strategy = GenerationType.SEQUENCE)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer sid;

	@Column(name = "SINGER_NAME")
	private String sname;

	@Column(name = "SINGER_CATEGORY")
	private String scategory;

	@Column(name = "SINGER_FEES")
	private Double fees;
}

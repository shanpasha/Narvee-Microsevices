package com.narvee.usit.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "Recruiter")
public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long recid;

	private Long vmsid;
	
	@Column(length = 100)
	private String recruiter;

	@Column(length = 20)
	private String usnumber;

	@Column(length = 20)
	private String innumber;

	@Column(length = 200)
	private String country;

	@Column(length = 100)
	private String iplogin;

	@Column(length = 200)
	private String fedid;

	@Column(length = 200)
	private String email;

	@Column(length = 255)
	private String linkedin;

	@Column(name = "status", length = 80)
	private String status = "Active";

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "createddate", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDate createddate;

	@Column(name = "updatedby")
	private long updatedby;

	@UpdateTimestamp
	private LocalDate updateddate;

	private long role;

	@Column(length = 255)
	private String remarks;

	@Column(length = 100)
	private String rec_stat = "Initiated";

	@Column(length = 200)
	private String designation;

	@Column(length = 255)
	private String details;

	@Column(length = 50)
	private String recruitertype;

	public Recruiter() {

	}

}

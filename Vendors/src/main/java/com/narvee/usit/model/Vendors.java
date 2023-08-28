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
@Table(name = "vendor")
public class Vendors {
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vmsid;
	@Column(length=200)
	private String company;

	@Column(length=200)
	private String location1;

	@Column(length=200)
	private String location2;

	@Column(length=200)
	private String fedid;

	@Column(length=200)
	private String Country;

	@Column(length=200)
	private String tyretype;

	@Column(length=200)
	private String vendortype;

	@Column(length=200)
	private String client;
	@Column(length=100)
	//private String vms_stat = "Entry";
	private String vms_stat = "Initiated";

	@Column(name = "status",length=100)
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

	@Column(length = 200)
	private String staff;

	@Column(length = 200)
	private String employeecount;

	@Column(length = 200)
	private String revenue;

	@Column(length = 255)
	private String website;

	@Column(length = 255)
	private String facebook;

	@Column(length = 20)
	private String phonenumber;

	@Column(length = 200)
	private String industrytype;
	@Column(length = 255)
	private String details;

	@Column(length = 255)
	private String linkedinid;

	@Column(length = 255)
	private String twitterid;


}

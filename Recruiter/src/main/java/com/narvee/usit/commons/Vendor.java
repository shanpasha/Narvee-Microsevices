package com.narvee.usit.commons;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

	
	private Long vmsid;
	private String company;
	private String location1;
	private String location2;
	private String fedid;
	private String Country;
	private String tyretype;
	private String vendortype;
	private String client;
	private String vms_stat = "Initiated";
	private String status = "Active";
			
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@CreationTimestamp
	private LocalDate createddate;
	private long updatedby;
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateddate;
	private long role;
	private String remarks;
	private String staff;
	private String employeecount;
	private String revenue;
	private String website;
	private String facebook;
	private String phonenumber;
	private String industrytype;
	private String details;
	private String linkedinid;
	private String twitterid;
	
}

package com.narvee.usit.commons;

import java.util.List;

import com.narvee.usit.model.Recruiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterResponse {

	private Recruiter recruiter;
	private Object vendor;

	List<Object> Asigned;

	public RecruiterResponse(Recruiter recruiter, Object vendor) {
		super();
		this.recruiter = recruiter;
		this.vendor = vendor;

	}

	public RecruiterResponse(List<Object> unAsign) {
		super();
		this.Asigned = unAsign;
	}

}

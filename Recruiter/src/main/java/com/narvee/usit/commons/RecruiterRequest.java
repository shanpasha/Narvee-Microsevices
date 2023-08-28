package com.narvee.usit.commons;

import com.narvee.usit.model.Recruiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterRequest {

	private Vendor vendor;
	private Recruiter recruiter;
}

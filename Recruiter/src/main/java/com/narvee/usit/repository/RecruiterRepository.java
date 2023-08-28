package com.narvee.usit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narvee.usit.model.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{
	
	public Recruiter findByRecruiter(String recruiter);

}

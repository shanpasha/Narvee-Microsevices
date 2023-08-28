package com.narvee.usit.service;

import com.narvee.usit.commons.RecruiterResponse;
import com.narvee.usit.model.Recruiter;

public interface RecruiterService {
	RecruiterResponse getAllRecruiters();
    RecruiterResponse getRecruiterById(Long id);
    Recruiter saveRecruiter(Recruiter recruiter);
    void deleteRecruiter(Long id);
    public RecruiterResponse findByRecruiter(String recruiter);
    
}


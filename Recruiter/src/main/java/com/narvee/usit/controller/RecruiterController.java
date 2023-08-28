package com.narvee.usit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.commons.RecruiterResponse;
import com.narvee.usit.model.Recruiter;
import com.narvee.usit.response.RestApiResponse;
import com.narvee.usit.service.RecruiterService;

@RestController
@RequestMapping("/api")
public class RecruiterController {

	private final RecruiterService recruiterService;

	private final Logger logger = LoggerFactory.getLogger(RecruiterController.class);

	@Autowired
	public RecruiterController(RecruiterService recruiterService) {
		this.recruiterService = recruiterService;
	}

	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<RestApiResponse> getAllRecruiters() {
		logger.info("RecruiterController.getAllRecruiters()");
		return new ResponseEntity<>(
				new RestApiResponse("success", "recruiters fetched sucessfully", recruiterService.getAllRecruiters()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RestApiResponse> getRecruiterById(@PathVariable Long id) {
		logger.info("RecruiterController.getRecruiterById()");
		return new ResponseEntity<>(
				new RestApiResponse("Success", "Get user by id ", recruiterService.getRecruiterById(id)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RestApiResponse> saveRecruiter(@RequestBody Recruiter recruiter) {
		logger.info("Received a request to create a new recruiter.");

		return new ResponseEntity<>(
				new RestApiResponse("success", "recruiter saved", recruiterService.saveRecruiter(recruiter)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<RestApiResponse> deleteRecruiter(@PathVariable Long id) {
		recruiterService.deleteRecruiter(id);
		return new ResponseEntity<>(new RestApiResponse("Success", "recruiter  deleted successfully", null),
				HttpStatus.OK);
	}

	@GetMapping("/getByRecruiter/{recruiter}")
	public ResponseEntity<RestApiResponse> findByRecruiter(@PathVariable String recruiter) {

		RecruiterResponse res = recruiterService.findByRecruiter(recruiter);
		return new ResponseEntity<RestApiResponse>(new RestApiResponse("sucess", "recruiter fetched sucessfully", res),
				HttpStatus.OK);

	}

}

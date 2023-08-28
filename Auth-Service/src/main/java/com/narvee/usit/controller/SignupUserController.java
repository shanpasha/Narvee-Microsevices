package com.narvee.usit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.commons.RestApiResponse;
import com.narvee.usit.dto.SignupRequest;
import com.narvee.usit.dto.UserDTO;
import com.narvee.usit.entity.User;
import com.narvee.usit.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/auth")
public class SignupUserController {

	@Autowired
	private AuthService auth;

	@PostMapping("/register")
	public ResponseEntity<RestApiResponse> createUser(@RequestBody SignupRequest signupRequest) {
		log.info("inside register method invoking...");
		log.info("User{}", signupRequest);
		if (signupRequest.getEmail() == null || signupRequest.getMobile() == null || signupRequest.getPassword() == null
				|| signupRequest.getUsername() == null) {

			log.info("failed to register user...please check all fields ");
			return new ResponseEntity<RestApiResponse>(
					new RestApiResponse("failed", "User not created. Please try again", null), HttpStatus.BAD_REQUEST);
		}

		User user = auth.getUser(signupRequest.getEmail());
		log.info("UserExists{}", user);
		if (user != null) {
			return new ResponseEntity<RestApiResponse>(
					new RestApiResponse("failed", "Email Id already registered", user.getEmail()),
					HttpStatus.BAD_REQUEST);

		} else {
			UserDTO createUser = auth.createUser(signupRequest);
			log.info("User registerd Sucessfully");
			return new ResponseEntity<RestApiResponse>(
					new RestApiResponse("sucess", "User created sucessfully", createUser), HttpStatus.OK);
		}

	}

}

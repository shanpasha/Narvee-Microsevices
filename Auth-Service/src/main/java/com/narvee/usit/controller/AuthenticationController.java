package com.narvee.usit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.dto.AuthenticationRequest;
import com.narvee.usit.dto.AuthenticationResponse;
import com.narvee.usit.serviceimpl.UserDetailsServiceImpl;
import com.narvee.usit.util.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userServiceImpl;

	@Autowired
	private JwtTokenUtil util;

	@PostMapping("/authentication")
	public AuthenticationResponse aunthenticate(@RequestBody AuthenticationRequest authRequest,
			HttpServletResponse response)
			throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {

		try {
			log.info("inside Authentication method");
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect Username or Password");
		} catch (DisabledException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not registerd please register");
		}

		log.info("Sucessfully completed Authentication");
		final UserDetails userDetails = userServiceImpl.loadUserByUsername(authRequest.getEmail());
		final String jwt = util.generateToken(userDetails.getUsername());
		log.info("JWT token generated sucessfully");
		return new AuthenticationResponse(jwt);

	}

}

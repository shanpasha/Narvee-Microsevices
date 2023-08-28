package com.narvee.usit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.narvee.usit.dto.SignupRequest;
import com.narvee.usit.dto.UserDTO;
import com.narvee.usit.model.User;
import com.narvee.usit.repository.UserRepository;
import com.narvee.usit.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRep;

	@Override
	public UserDTO createUser(SignupRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
		user.setMobile(request.getMobile());
		User createUser = userRep.save(user);
		UserDTO us = new UserDTO();

		us.setEmail(createUser.getEmail());
		us.setMobile(createUser.getMobile());
		us.setUsername(createUser.getUsername());
		return us;

	}

	@Override
	public User getUser(String email) {

		return userRep.findByEmail(email);
	}

}

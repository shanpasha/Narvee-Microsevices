package com.narvee.usit.service;

import com.narvee.usit.dto.SignupRequest;
import com.narvee.usit.dto.UserDTO;
import com.narvee.usit.entity.User;

public interface AuthService {

	public UserDTO createUser(SignupRequest request);
	public User getUser(String email);
}

package com.narvee.usit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narvee.usit.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}

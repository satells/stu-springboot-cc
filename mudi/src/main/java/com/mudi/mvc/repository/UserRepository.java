package com.mudi.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mudi.mvc.model.User;

@Repository
public interface UserRepository
		extends JpaRepository<User, String> {

	User findByUsername(String username);

}

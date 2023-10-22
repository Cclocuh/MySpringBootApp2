package com.gcu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}

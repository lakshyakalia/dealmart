package com.dealmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dealmart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}

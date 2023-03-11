package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.module.UsersSessions;

@Repository
public interface UserSessionDao extends JpaRepository<UsersSessions, String>{

	public Optional<UsersSessions> findByUuId(String key);
	
	
	public Optional<UsersSessions> findByUserId(String key);
}

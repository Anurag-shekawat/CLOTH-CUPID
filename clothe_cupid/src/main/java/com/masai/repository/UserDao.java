package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.module.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer>{

	public Optional<Users> findByUuId(String key);
	
	
	public Optional<Users> findByUserId(String key);
}

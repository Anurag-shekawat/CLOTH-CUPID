package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.module.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

	public Optional<Users> findByUuId(String key);
	
}

package com.masai.repository;

import com.masai.module.Admin;
import com.masai.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findByEmail(String email);
}

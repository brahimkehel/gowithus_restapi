package com.emsi.gowithus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsi.gowithus.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}

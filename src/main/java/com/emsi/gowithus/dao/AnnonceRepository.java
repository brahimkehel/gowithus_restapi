package com.emsi.gowithus.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsi.gowithus.model.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{
}

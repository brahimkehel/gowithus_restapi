package com.emsi.gowithus.dao;

import com.emsi.gowithus.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
}

package com.emsi.gowithus.dao;


import com.emsi.gowithus.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {

}

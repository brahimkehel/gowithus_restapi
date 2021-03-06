package com.emsi.gowithus.dao;

import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    Conducteur findByUsername(String username);

    List<AppUser> findByApprouvedIsTrue();

    List<Conducteur> findByApprouvedTrue();

    List<Conducteur> findByApprouvedFalse();
}

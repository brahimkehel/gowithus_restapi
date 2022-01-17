package com.emsi.gowithus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody Conducteur conducteur) {
        return ResponseEntity.ok().body(utilisateurRepository.save(conducteur));
    }

}

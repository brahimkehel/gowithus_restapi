package com.emsi.gowithus.controller;

import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Utilisateurs")
public class UtilisateurController {

    @Autowired
    private IUtilisateurService utilisateurService;

    @PostMapping("/saveConducteur")
    public ResponseEntity<AppUser> saveConducteur(@RequestBody Conducteur conducteur) {
        AppUser user = utilisateurService.saveUser(conducteur);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/savePassager")
    public ResponseEntity<AppUser> savePassager(@RequestBody Passager passager) {
        AppUser user = utilisateurService.saveUser(passager);
        return ResponseEntity.ok().body(user);
    }
}

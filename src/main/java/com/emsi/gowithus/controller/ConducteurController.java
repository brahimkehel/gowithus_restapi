package com.emsi.gowithus.controller;

import java.util.ArrayList;
import java.util.List;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.model.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.service.IAnnonceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("Conducteurs")
public class ConducteurController {
    @Autowired
    private IAnnonceService annonceService;
    @Autowired
    private ConducteurRepository conducteurRepository;

    @PostMapping("{id}/saveAnnonce")
    public ResponseEntity<String> addAnnonce(@PathVariable int id, @RequestBody Annonce annonce) {
        try {
            if (id == 0 && !conducteurRepository.findById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Conducteur c = conducteurRepository.findById(id).get();
            c.addAnnonce(annonce);
            annonceService.saveAnnonce(annonce);
            return ResponseEntity.created(null).body(c.toString());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("{id}/Annonces")
    public ResponseEntity getAnnoncesByConducteur(@PathVariable int id) {
        try {
            if (id == 0 && !conducteurRepository.findById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(conducteurRepository.getById(id).getAnnonces());
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.emsi.gowithus.controller;

import java.util.ArrayList;
import java.util.List;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.service.IConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.service.IAnnonceService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("Conducteurs")
public class ConducteurController {
    @Autowired
    private IAnnonceService annonceService;
    @Autowired
    private IConducteurService conducteurService;

    @PostMapping("{username}/saveAnnonce")
    public ResponseEntity<String> addAnnonce(@PathVariable String username, @RequestBody Annonce annonce) {
        try {
            annonceService.saveAnnonce(username,annonce);
            return ResponseEntity.created(null).build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("{username}/Annonces")
    public ResponseEntity<List<Annonce>> getAnnoncesByConducteur(@PathVariable String username) {
        try {
            return ResponseEntity.ok(annonceService.getAnnoncesByConducteur(username));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/approuved")
    public ResponseEntity<List<Conducteur>> getAllAprrouved(){
        try{
            return ResponseEntity.ok(conducteurService.getAllAprrouved());
        }catch(Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nonapprouved")
    public ResponseEntity<List<Conducteur>> getAllNonApprouved(){
        try{
            return ResponseEntity.ok(conducteurService.getAllNonApprouved());
        }catch(Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> setApprouvedConducteur(@PathVariable int id){
        try{
             conducteurService.setApprouvedUser(id);
             return ResponseEntity.ok("modifie avec success");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

package com.emsi.gowithus.controller;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.service.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Annonces")
public class AnnonceController {
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private IAnnonceService annonceService;

    @GetMapping("")
    public ResponseEntity<List<Annonce>> getAnnonces(@RequestParam String depart, @RequestParam String arrive, @RequestParam String date) {
        try{
            return ResponseEntity.ok(annonceService.getAnnonceByArgs(depart,arrive,date));
        }catch(Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }
}

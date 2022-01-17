package com.emsi.gowithus.controller;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Annonces")
public class AnnonceController {
    @Autowired
    private AnnonceRepository annonceRepository;

    @GetMapping("")
    public ResponseEntity<List<Annonce>> getAnnonce(@RequestParam String depart,@RequestParam String arrive){
        if(depart== null || arrive==null){
            return ResponseEntity.badRequest().build();
        }
        System.out.println(depart+arrive);
        return ResponseEntity.ok(annonceRepository.findAll().stream().filter(a->
                Objects.equals(a.getDepart(), depart) &&
                        Objects.equals(a.getArrive(), arrive)
        ).collect(Collectors.toList()));
    }
}

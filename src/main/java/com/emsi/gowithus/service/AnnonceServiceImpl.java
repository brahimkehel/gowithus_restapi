package com.emsi.gowithus.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.model.Conducteur;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AnnonceServiceImpl implements IAnnonceService {
    private final AnnonceRepository annonceRepository;
    private final ConducteurRepository conducteurRepository;

    @Override
    public void saveAnnonce(String conducteur_username, Annonce annonce) throws Exception {
        if (conducteur_username == "" || conducteurRepository.findByUsername(conducteur_username) == null) {
            throw new Exception("Conducteur not found");
        }
        Conducteur c = conducteurRepository.findByUsername(conducteur_username);
        c.addAnnonce(annonce);
        annonceRepository.save(annonce);
    }

    @Override
    public List<Annonce> getAnnoncesByConducteur(String conducteur_username) throws Exception {
        if (conducteur_username == "" || conducteurRepository.findByUsername(conducteur_username) == null) {
            throw new Exception("Conducteur not found");
        }
        Conducteur c = conducteurRepository.findByUsername(conducteur_username);
        return c.getAnnonces();
    }

    @Override
    public List<Annonce> getAnnonceByArgs(String depart, String arrive, String date) throws Exception {
        if (depart == null || arrive == null || date == null) {
            throw new Exception("Args connot be set to null");
        }
        System.out.println(depart + " " + arrive + " " + date);
        return annonceRepository.findAll().stream().filter(a ->
                a.getDepart() != null && a.getArrive() != null && a.getDate() != null &&
                        Objects.equals(a.getDepart(), depart) &&
                        Objects.equals(a.getArrive(), arrive) &&
                        a.getDate().compareTo(LocalDate.parse(date)) == 0
        ).collect(Collectors.toList());
    }

}

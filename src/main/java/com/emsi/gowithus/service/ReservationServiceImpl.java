package com.emsi.gowithus.service;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.dao.ReservationRepository;
import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AnnonceRepository annonceRepository;

    @Override
    public void saveReservation(String passager_username,int annonce_id) throws Exception {
        if (passager_username == "" || utilisateurRepository.findByUsername(passager_username)==null) {
            throw new Exception("Utilisateur not found");
        }
        Passager p=(Passager) utilisateurRepository.findByUsername(passager_username);
        Annonce a=annonceRepository.findById(annonce_id).get();
        Reservation r=new Reservation();
        p.addReservation(r);
        a.addReservation(r);
        reservationRepository.save(r);
    }

    @Override
    public List getReservationsByPassager(String passager_username) throws Exception {
        if (passager_username == "" || utilisateurRepository.findByUsername(passager_username)==null) {
            throw new Exception("Utilisateur not found");
        }
        return ((Passager) utilisateurRepository.findByUsername(passager_username)).getReservations().stream().map(r->r.getAnnonce()).collect(Collectors.toList());
    }
}

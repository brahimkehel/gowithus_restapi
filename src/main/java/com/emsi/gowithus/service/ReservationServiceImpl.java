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
    public void saveReservation(int passager_id,int annonce_id) throws Exception {
        if (passager_id == 0 || !utilisateurRepository.findById(passager_id).isPresent()) {
            throw new Exception("Utilisateur not found");
        }
        Passager p=(Passager) utilisateurRepository.findById(passager_id).get();
        Annonce a=annonceRepository.findById(annonce_id).get();
        Reservation r=new Reservation();
        p.addReservation(r);
        a.addReservation(r);
        reservationRepository.save(r);
    }

    @Override
    public List<Reservation> getReservationsByPassager(int passager_id) throws Exception {
        if (passager_id == 0 || !utilisateurRepository.findById(passager_id).isPresent()) {
            throw new Exception("Utilisateur not found");
        }
        return ((Passager) utilisateurRepository.findById(passager_id).get()).getReservations();
    }
}

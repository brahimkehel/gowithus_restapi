package com.emsi.gowithus.controller;

import com.emsi.gowithus.model.Reservation;
import com.emsi.gowithus.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("Passagers")
public class PassagerController {
    @Autowired
    private IReservationService reservationService;

    @GetMapping("{passager_id}/Reservations")
    public ResponseEntity<List<Reservation>> getReservationsByPassager(@PathVariable int passager_id) {
        try {
            reservationService.getReservationsByPassager(passager_id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("{passager_id}/{annonce_id}")
    public ResponseEntity<String> saveReservation(@PathVariable int passager_id, @PathVariable int annonce_id) {
        try {
            reservationService.saveReservation(passager_id,annonce_id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
package com.emsi.gowithus.controller;

import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.model.Reservation;
import com.emsi.gowithus.service.IPassagerService;
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
    @Autowired
    private IPassagerService passagerService;

    @GetMapping("{username}/Reservations")
    public ResponseEntity<List<Reservation>> getReservationsByPassager(@PathVariable String username) {
        try {
            return ResponseEntity.ok(reservationService.getReservationsByPassager(username));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("{username}/{annonce_id}")
    public ResponseEntity<String> saveReservation(@PathVariable String username, @PathVariable int annonce_id) {
        try {
            reservationService.saveReservation(username,annonce_id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Passager>> getAll(){
        try{
            return ResponseEntity.ok().body(passagerService.getAll());
        }catch(Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }
}

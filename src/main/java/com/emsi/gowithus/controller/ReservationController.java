package com.emsi.gowithus.controller;

import com.emsi.gowithus.domain.ReservationVo;
import com.emsi.gowithus.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private IReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationVo>> getReservations(){
        List<ReservationVo> reservations=reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
    @PostMapping("/reservation")
    public ResponseEntity saveReservation(@RequestBody ReservationVo reservationVo){
            reservationService.saveReservation(reservationVo);
            return new ResponseEntity<>("Reservation crée avec succes", HttpStatus.CREATED);
    }

}

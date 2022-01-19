package com.emsi.gowithus.service;

import com.emsi.gowithus.model.Reservation;

import java.util.List;

public interface IReservationService {
    void saveReservation(String passager_username,int annonce_id) throws Exception;
    List<Reservation> getReservationsByPassager(String passager_username) throws Exception;
}

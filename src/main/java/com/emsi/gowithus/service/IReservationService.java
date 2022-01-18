package com.emsi.gowithus.service;

import com.emsi.gowithus.model.Reservation;

import java.util.List;

public interface IReservationService {
    void saveReservation(int passager_id,int annonce_id) throws Exception;
    List<Reservation> getReservationsByPassager(int passager_id) throws Exception;
}

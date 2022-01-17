package com.emsi.gowithus.service;

import com.emsi.gowithus.domain.ReservationVo;

import java.util.List;

public interface IReservationService {
    List<ReservationVo> getAllReservations();
    void saveReservation(ReservationVo reservationVo);
}

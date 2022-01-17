package com.emsi.gowithus.service;

import com.emsi.gowithus.dao.ReservationRepository;
import com.emsi.gowithus.domain.ReservationConverter;
import com.emsi.gowithus.domain.ReservationVo;
import com.emsi.gowithus.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationVo> getAllReservations() {
        List<ReservationVo> reservations= ReservationConverter.toVoList(reservationRepository.findAll());
        return reservations;
    }

    @Override
    public void saveReservation(ReservationVo reservationVo) {
        Reservation reservation=ReservationConverter.toBo(reservationVo);
        reservationRepository.save(reservation);
    }
}

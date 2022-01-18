package com.emsi.gowithus.dao;

import com.emsi.gowithus.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findAll();
    Reservation findReservationById(int id);
}

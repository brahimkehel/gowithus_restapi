package com.emsi.gowithus.dao;

import com.emsi.gowithus.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}

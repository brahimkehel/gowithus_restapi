package com.emsi.gowithus.domain;

import com.emsi.gowithus.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationConverter {
    public static Reservation toBo(ReservationVo reservationVo) {
        if (reservationVo == null) return null;
        Reservation rBo = new Reservation();
        rBo.setId(reservationVo.getId());
        rBo.setAnnonce(AnnonceConverter.toBo(reservationVo.getAnnonceVo()));
        rBo.setPassager(PassagerConverter.toBo(reservationVo.getPassagerVo()));
        return rBo;
    }

    public static ReservationVo toVo(Reservation reservationBo) {
        if (reservationBo == null) return null;
        ReservationVo rVo = new ReservationVo();
        rVo.setAnnonceVo(AnnonceConverter.toVo(reservationBo.getAnnonce()));
        rVo.setPassagerVo(PassagerConverter.toVo(reservationBo.getPassager()));
        rVo.setId(reservationBo.getId());
        return rVo;
    }

    public static List<Reservation> toBoList(List<ReservationVo> reservationVos) {
        if (reservationVos == null || reservationVos.isEmpty()) return null;
        List<Reservation> rBoList = new ArrayList<>();
        reservationVos.forEach(r -> rBoList.add(toBo(r)));
        return rBoList;
    }

    public static List<ReservationVo> toVoList(List<Reservation> reservationBos) {
        if (reservationBos == null || reservationBos.isEmpty()) return null;
        List<ReservationVo> rVoList = new ArrayList<>();
        reservationBos.forEach(r -> rVoList.add(toVo(r)));
        return rVoList;
    }
}

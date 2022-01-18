package com.emsi.gowithus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AnnonceVo {
    private int id;
    private String depart;
    private String arrive;
    private float prix;
    private ConducteurVo conducteurVo;
    private List<ReservationVo> reservations=new ArrayList<>();

}

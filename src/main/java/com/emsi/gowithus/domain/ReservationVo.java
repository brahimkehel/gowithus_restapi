package com.emsi.gowithus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationVo {
    private int id;
    private PassagerVo passagerVo;
    private AnnonceVo annonceVo;

    public ReservationVo(PassagerVo passagerVo, AnnonceVo annonceVo) {
        this.passagerVo = passagerVo;
        this.annonceVo = annonceVo;
    }
}

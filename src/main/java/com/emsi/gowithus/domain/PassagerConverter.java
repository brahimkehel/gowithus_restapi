package com.emsi.gowithus.domain;

import com.emsi.gowithus.model.Passager;

public class PassagerConverter {
    public static Passager toBo(PassagerVo passagerVo){
        if(passagerVo==null)return null;
        Passager pBo=new Passager();
        pBo.setReservations(ReservationConverter.toBoList(passagerVo.getReservations()));
        return pBo;
    }
    public static PassagerVo toVo(Passager passagerBo){
        if(passagerBo==null)return null;
        PassagerVo pVo=new PassagerVo();
        pVo.setReservations(ReservationConverter.toVoList(passagerBo.getReservations()));
        return pVo;
    }
}

package com.emsi.gowithus.domain;

import com.emsi.gowithus.model.Annonce;

import java.util.ArrayList;
import java.util.List;

public class AnnonceConverter {
    public static Annonce toBo(AnnonceVo annonceVo) {
        if (annonceVo == null) return null;
        Annonce aBo = new Annonce();
        aBo.setId(annonceVo.getId());
        aBo.setArrive(annonceVo.getArrive());
        aBo.setDepart(annonceVo.getDepart());
        aBo.setPrix(annonceVo.getPrix());
        aBo.setConducteur(ConducteurConverter.toBo(annonceVo.getConducteurVo()));
        aBo.setReservations(ReservationConverter.toBoList(annonceVo.getReservations()));
        return aBo;
    }

    public static AnnonceVo toVo(Annonce annonceBo) {
        if(annonceBo==null)return null;
        AnnonceVo aVo=new AnnonceVo();
        aVo.setArrive(annonceBo.getArrive());
        aVo.setDepart(annonceBo.getDepart());
        aVo.setId(annonceBo.getId());
        aVo.setPrix(annonceBo.getPrix());
        aVo.setReservations(ReservationConverter.toVoList(annonceBo.getReservations()));
        aVo.setConducteurVo(ConducteurConverter.toVo(annonceBo.getConducteur()));
        return aVo;
    }

    public static List<Annonce> toBoList(List<AnnonceVo> annonceVos) {
        if (annonceVos == null || annonceVos.isEmpty()) return null;
        List<Annonce> boList = new ArrayList<>();
        annonceVos.forEach(a -> boList.add(toBo(a)));
        return boList;
    }

    public static List<AnnonceVo> toVoList(List<Annonce> annonceBos) {
        if (annonceBos == null || annonceBos.isEmpty()) return null;
        List<AnnonceVo> voList = new ArrayList<>();
        annonceBos.forEach(a -> voList.add(toVo(a)));
        return voList;
    }
}

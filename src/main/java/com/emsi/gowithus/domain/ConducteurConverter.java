package com.emsi.gowithus.domain;

import com.emsi.gowithus.model.Conducteur;

public class ConducteurConverter {

    public static Conducteur toBo(ConducteurVo conducteurVo) {
        if (conducteurVo == null) return null;
        Conducteur conducteurBo = new Conducteur();
        conducteurBo.setMarque(conducteurVo.getMarque());
        conducteurBo.setNb_places(conducteurVo.getNb_places());
        conducteurBo.setCin(conducteurVo.getCin());
        conducteurBo.setEmail(conducteurVo.getEmail());
        conducteurBo.setNom(conducteurVo.getNom());
        conducteurBo.setPrenom(conducteurVo.getPrenom());
        conducteurBo.setPassword(conducteurVo.getPassword());
        conducteurBo.setId(conducteurVo.getId());
        conducteurBo.setUsername(conducteurVo.getUsername());
        conducteurBo.setAnnonces(AnnonceConverter.toBoList(conducteurVo.getAnnonces()));
        return conducteurBo;
    }

    public static ConducteurVo toVo(Conducteur conducteurBo) {
        if (conducteurBo == null) return null;
        ConducteurVo cVo = new ConducteurVo();
        cVo.setAnnonces(AnnonceConverter.toVoList(conducteurBo.getAnnonces()));
        cVo.setMarque(conducteurBo.getMarque());
        cVo.setNb_places(conducteurBo.getNb_places());
        cVo.setCin(conducteurBo.getCin());
        cVo.setEmail(conducteurBo.getEmail());
        cVo.setNom(conducteurBo.getNom());
        cVo.setPrenom(conducteurBo.getPrenom());
        cVo.setPassword(conducteurBo.getPassword());
        cVo.setId(conducteurBo.getId());
        cVo.setUsername(conducteurBo.getUsername());
        return cVo;
    }
}

package com.emsi.gowithus.domain;

import com.emsi.gowithus.model.Annonce;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ConducteurVo {
    private Long id;
    private String cin;
    private String password;
    private int tel;
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String marque;
    private int nb_places;
    private List<AnnonceVo> annonces=new ArrayList<>();
}

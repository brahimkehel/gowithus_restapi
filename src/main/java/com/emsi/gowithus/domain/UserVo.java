package com.emsi.gowithus.domain;


import com.emsi.gowithus.model.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserVo {
    private Long id;
    private String username;
    private String password;
    private String nom;
    private String prenom;
    private String email;
    private int tel;
    private String cin;
    private List<RoleVo> roles = new ArrayList<RoleVo>();

    public UserVo(Long id, String username, String password, String nom, String prenom, String email, int tel, String cin, List<RoleVo> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.cin = cin;
        this.roles = roles;
    }

}

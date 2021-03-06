package com.emsi.gowithus.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserVo {
    private Long id;
    private String cin;
    private String username;
    private String password;
    private String email;
    private String nom;
    private String prenom;
    private int tel;
    private List<RoleVo> roles = new ArrayList<RoleVo>();

}

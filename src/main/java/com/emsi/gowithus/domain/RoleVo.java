package com.emsi.gowithus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleVo {
    private int id;
    private String name;

    public RoleVo(String role) {
        this.name = role;
    }
}

package com.emsi.gowithus.domain;

import com.emsi.gowithus.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static UserVo toVo(AppUser bo) {
        if (bo == null) return null;
        UserVo vo = new UserVo();
        vo.setId(bo.getId());
        vo.setUsername(bo.getUsername());
        vo.setPassword(bo.getPassword());
        vo.setRoles(RoleConverter.toVoList(bo.getRoles()));
        vo.setCin(bo.getCin());
        vo.setNom(bo.getNom());
        vo.setPrenom(bo.getPrenom());
        vo.setEmail(bo.getEmail());
        vo.setTel(bo.getTel());
        return vo;
    }

    public static AppUser toBo(UserVo vo) {
        if (vo == null) return null;
        AppUser bo = new AppUser();
        if (vo.getId() != null) bo.setId(vo.getId());
        bo.setUsername(vo.getUsername());
        bo.setPassword(vo.getPassword());
        bo.setRoles(RoleConverter.toBoList(vo.getRoles()));
        bo.setCin(vo.getCin());
        bo.setNom(vo.getNom());
        bo.setPrenom(vo.getPrenom());
        bo.setEmail(vo.getEmail());
        bo.setTel(vo.getTel());
        return bo;
    }

    public static List<UserVo> toVoList(List<AppUser> boList) {
        if (boList == null || boList.isEmpty()) return null;
        List<UserVo> voList = new ArrayList<>();
        for (AppUser AppUser : boList) {
            voList.add(toVo(AppUser));
        }
        return voList;
    }

    public static List<AppUser> toBoList(List<UserVo> voList) {
        if (voList == null || voList.isEmpty()) return null;
        List<AppUser> boList = new ArrayList<>();
        voList.forEach(u -> boList.add(toBo(u)));
        return boList;
    }

}

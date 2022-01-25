package com.emsi.gowithus.service;

import com.emsi.gowithus.model.Conducteur;

import java.util.List;

public interface IConducteurService {
    List<Conducteur> getAllAprrouved();
    List<Conducteur> getAllNonApprouved();
}

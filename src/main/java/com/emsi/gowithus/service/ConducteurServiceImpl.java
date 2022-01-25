package com.emsi.gowithus.service;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ConducteurServiceImpl implements IConducteurService{
    @Autowired
    private ConducteurRepository conducteurRepository;

    @Override
    public List<Conducteur> getAllAprrouved() {
        List<Conducteur> approuvedUsers = conducteurRepository.findByApprouvedTrue();
        return approuvedUsers;
    }

    @Override
    public List<Conducteur> getAllNonApprouved() {
        List<Conducteur> approuvedUsers = conducteurRepository.findByApprouvedFalse();
        return approuvedUsers;
    }
}

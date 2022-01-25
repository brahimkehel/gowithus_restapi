package com.emsi.gowithus.service;

import com.emsi.gowithus.dao.PassagerRepository;
import com.emsi.gowithus.model.Passager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PassagerServiceImpl implements IPassagerService{
    @Autowired
    private PassagerRepository passagerRepository;

    @Override
    public List<Passager> getAll() {
        return passagerRepository.findAll();
    }
}

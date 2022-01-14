package com.emsi.gowithus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.Conducteur;

@Transactional
@Service
public class UtilisateurServiceImpl implements IUtilisateurService,CommandLineRunner{
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	@Override
	public void saveConducteur(Conducteur conducteur) {
		utilisateurRepo.save(conducteur);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}

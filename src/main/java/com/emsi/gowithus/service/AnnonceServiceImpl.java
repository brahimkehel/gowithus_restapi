package com.emsi.gowithus.service;

import java.util.List;

import javax.transaction.Transactional;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.model.Conducteur;
import org.springframework.stereotype.Service;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AnnonceServiceImpl implements IAnnonceService{
	private final AnnonceRepository annonceRepository;
	private final ConducteurRepository conducteurRepository;

	@Override
	public void saveAnnonce(String conducteur_username,Annonce annonce) throws Exception {
		if(conducteur_username=="" || conducteurRepository.findByUsername(conducteur_username)==null){
			throw new Exception();
		}
		Conducteur c = conducteurRepository.findByUsername(conducteur_username);
		c.addAnnonce(annonce);
		annonceRepository.save(annonce);
	}

	@Override
	public List<Annonce> getAnnoncesByConducteur(String conducteur_username) throws Exception {
		if(conducteur_username=="" || conducteurRepository.findByUsername(conducteur_username)==null){
			throw new Exception();
		}
		Conducteur c = conducteurRepository.findByUsername(conducteur_username);
		return c.getAnnonces();
	}

}

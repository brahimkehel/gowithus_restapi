package com.emsi.gowithus.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Override
	public Annonce saveAnnonce(Annonce annonce) {
		return annonceRepository.save(annonce);
	}

	@Override
	public Annonce updateAnnonce(Annonce annonce) {
		return annonceRepository.save(annonce);
	}

	@Override
	public void deleteAnnonce(int id) {
		annonceRepository.deleteById(id);
	}


	
}

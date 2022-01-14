package com.emsi.gowithus.service;



import java.util.List;

import com.emsi.gowithus.model.Annonce;

public interface IAnnonceService {
	Annonce saveAnnonce(Annonce annonce);
	Annonce updateAnnonce(Annonce annonce);
	void deleteAnnonce(int id);
}	
package com.emsi.gowithus.service;



import java.util.List;

import com.emsi.gowithus.model.Annonce;

public interface IAnnonceService {
	void saveAnnonce(String conducteur_username,Annonce annonce) throws Exception;
	List<Annonce> getAnnoncesByConducteur(String conducteur_username) throws Exception;
}	
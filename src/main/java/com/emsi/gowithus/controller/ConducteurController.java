package com.emsi.gowithus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.service.IAnnonceService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("Conducteurs")
public class ConducteurController {
	@Autowired
	private IAnnonceService annonceService;
	
	@PostMapping("save")
	public ResponseEntity<Annonce> addAnnonce(@RequestBody Annonce annonce) {
		return ResponseEntity.created(null).body(annonceService.saveAnnonce(annonce));
	}
	

}

package com.emsi.gowithus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.service.IAnnonceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("Conducteurs")
public class ConducteurController {
	@Autowired
	private IAnnonceService annonceService;
	
	@PostMapping("save")
	public ResponseEntity<Annonce> addAnnonce(@RequestBody Annonce annonce) {
		return ResponseEntity.created(null).body(annonceService.saveAnnonce(annonce));
	}
	

}

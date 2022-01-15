package com.emsi.gowithus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.model.Role;
import com.emsi.gowithus.service.UtilisateurServiceImpl;

import lombok.extern.slf4j.Slf4j;
@SpringBootApplication()
@Slf4j
public class GowithusApplication{

	public static void main(String[] args) {
		SpringApplication.run(GowithusApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(UtilisateurServiceImpl utilisateurServiceImpl,AnnonceRepository annonceRepository) {
		return args->{
			utilisateurServiceImpl.saveRole(new Role("ROLE_Conducteur"));
			utilisateurServiceImpl.saveRole(new Role( "ROLE_Passager"));
			
			AppUser u=new AppUser();
			u.setCin("d1");
			u.setNom("hamada");
			u.setPrenom("hamiid");
			u.setUsername("abouuu");
			u.setEmail("hamid@gmail.com");
			u.setPassword("123456");
			u.setTel(123456);
			
			utilisateurServiceImpl.saveUser(u);
			utilisateurServiceImpl.addRoleToUser("abouuu", "ROLE_Passager");
			utilisateurServiceImpl.addRoleToUser("abouuu", "ROLE_Conducteur");
			
			//UserDetails ud=utilisateurServiceImpl.loadUserByUsername("abouuu");
			
			Conducteur c=new Conducteur();
			c.setCin("d1");
			c.setNom("hamada");
			c.setPrenom("hamiid");
			c.setUsername("hamiid");
			c.setEmail("hamid@gmail.com");
			c.setPassword("123456");
			c.setMarque("golf");
			c.setTel(123456);
			c.setNb_places(3);
			
			
			Annonce a=new Annonce();
			a.setDepart("a");
			a.setArrive("b");
			a.setPrix(200);
			
			Annonce a2=new Annonce();
			a2.setDepart("aaa");
			a2.setArrive("bbb");
			a2.setPrix(300);
			
			
			c.addAnnonce(a);
			c.addAnnonce(a2);
			
			

			utilisateurServiceImpl.saveUser(c);
			annonceRepository.save(a);annonceRepository.save(a2);

			
			//utilisateurServiceImpl.addRoleToUser("hamiid", "ROLE_Conducteur");
			utilisateurServiceImpl.addRoleToUser("hamiid", "ROLE_Passager");
			
			log.info("annonce : {}",c.getAnnonces().get(0).getConducteur().getRoles());
			
			
		};
	}
}

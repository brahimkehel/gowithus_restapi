package com.emsi.gowithus;


import com.emsi.gowithus.dao.ReservationRepository;
import com.emsi.gowithus.domain.*;
import com.emsi.gowithus.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.service.UtilisateurServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.transaction.Transactional;

@SpringBootApplication()
@Slf4j
public class GowithusApplication{

	public static void main(String[] args) {
		SpringApplication.run(GowithusApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Bean
	@Transactional
	CommandLineRunner run(UtilisateurServiceImpl utilisateurServiceImpl, AnnonceRepository annonceRepository, ReservationRepository reservationRepository) {
		return args->{
			utilisateurServiceImpl.saveRole(new Role("ROLE_Conducteur"));
			utilisateurServiceImpl.saveRole(new Role( "ROLE_Passager"));
			
			AppUser u=new AppUser();
			u.setId(0L);
			u.setCin("d1");
			u.setNom("hamada");
			u.setPrenom("hamiid");
			u.setUsername("abdslam");
			u.setEmail("hamid@gmail.com");
			u.setPassword("123456");
			u.setTel(123456);
			utilisateurServiceImpl.saveUser(u);
			utilisateurServiceImpl.addRoleToUser("abdslam", "ROLE_Passager");
			utilisateurServiceImpl.addRoleToUser("abdslam", "ROLE_Conducteur");

			//UserDetails ud=utilisateurServiceImpl.loadUserByUsername("abouuu");
			
			Conducteur c=new Conducteur();
			c.setCin("d1");
			c.setNom("hamada");
			c.setPrenom("abo");
			c.setUsername("hamiid");
			c.setEmail("hamid@gmail.com");
			c.setPassword("123456");
			c.setMarque("golf");
			c.setTel(123456);
			c.setNb_places(3);

			Passager p=new Passager();
			p.setCin("d1");
			p.setNom("abdelilah");
			p.setPrenom("hassani");
			p.setUsername("hassani");
			p.setEmail("hamid@gmail.com");
			p.setPassword("123456");
			p.setTel(123456);
			
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

			Reservation r=new Reservation();


			c.addAnnonce(a);
			c.addAnnonce(a2);

			utilisateurServiceImpl.saveUser(c);
			utilisateurServiceImpl.saveUser(p);

			annonceRepository.save(a);
			annonceRepository.save(a2);
			//utilisateurServiceImpl.addRoleToUser("hamiid", "ROLE_Passager");

			//utilisateurServiceImpl.addRoleToUser("nsisib","Passager");

			/*a.addReservation(r);
			p.addReservation(r);
			reservationRepository.save(r);*/

			
			//utilisateurServiceImpl.addRoleToUser("hamiid", "ROLE_Conducteur");c.getAnnonces().get(0).getReservations().get(0).getAnnonce().getConducteur().getRoles()

			log.info("annonce : {}",p.getReservations());


		};
	}
}

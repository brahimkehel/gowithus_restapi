package com.emsi.gowithus;


import com.emsi.gowithus.dao.PassagerRepository;
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
import java.util.ArrayList;

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
<<<<<<< HEAD
			Passager p=new Passager();
			p.setCin("ad264785");
			p.setUsername("test@gmail.com");
			p.setNom("Hamid");
			p.setPrenom("Haddri");
			p.setEmail("test@gmail.com");
			p.setPassword("emsi123");
			p.setTel(654785);
			Passager p1=new Passager();
			p1.setCin("ad264785");
			p1.setUsername("froukh@gmail.com");
			p1.setNom("Abouu");
			p1.setPrenom("Hassan");
			p1.setEmail("froukh@gmail.com");
			p1.setPassword("emsi123");
			p1.setTel(654785);
			Passager p2=new Passager();
			p2.setCin("ad264785");
			p2.setUsername("Mustapha@gmail.com");
			p2.setNom("Hssaini");
			p2.setPrenom("Abdelilah");
			p2.setEmail("Mustapha@gmail.com");
			p2.setPassword("emsi123");
			p2.setTel(654785);
			Conducteur c=new Conducteur();
			c.setCin("ad264785");
			c.setUsername("abdelghani@gmail.com");
			c.setNom("Salihoun");
			c.setPrenom("Mohamed");
			c.setEmail("abdelghani@gmail.com");
			c.setPassword("emsi123");
			c.setTel(654785);
			c.setMarque("Dacia");
			c.setNb_places(4);
			c.setApprouved(true);
			Conducteur c1=new Conducteur();
			c1.setCin("ad264785");
			c1.setUsername("chelioui@gmail.com");
			c1.setNom("chelioui");
			c1.setPrenom("Imane");
			c1.setEmail("chelioui@gmail.com");
			c1.setPassword("emsi123");
			c1.setTel(654785);
			c1.setMarque("fiat500");
			c1.setNb_places(2);
			c1.setApprouved(true);
			Conducteur c2=new Conducteur();
			c2.setCin("ad264785");
			c2.setUsername("harrami@gmail.com");
			c2.setNom("harrami");
			c2.setPrenom("Mouad");
			c2.setEmail("harrami@gmail.com");
			c2.setPassword("emsi123");
			c2.setTel(654785);
			c2.setMarque("peugeot 208");
			c2.setNb_places(4);
			c2.setApprouved(true);
=======
			
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
			a2.setDepart("a");
			a2.setArrive("b");
			a2.setPrix(300);
			c.addAnnonce(a);
			c.addAnnonce(a2);

			Reservation r=new Reservation();


			c.addAnnonce(a);
			c.addAnnonce(a2);

			utilisateurServiceImpl.saveUser(c);
>>>>>>> 3bb7ec83df9462d901f6bfe6fdcee36941777bf2
			utilisateurServiceImpl.saveUser(p);
			utilisateurServiceImpl.saveUser(p1);
			utilisateurServiceImpl.saveUser(p2);
			utilisateurServiceImpl.saveUser(c);
			utilisateurServiceImpl.saveUser(c1);
			utilisateurServiceImpl.saveUser(c2);


		};
	}
}

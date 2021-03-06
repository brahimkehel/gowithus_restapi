package com.emsi.gowithus;


import com.emsi.gowithus.dao.AnnonceRepository;
import com.emsi.gowithus.dao.ReservationRepository;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.model.Role;
import com.emsi.gowithus.service.UtilisateurServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
			utilisateurServiceImpl.saveRole(new Role( "ROLE_Admin"));

			Passager p=new Passager();
			p.setCin("ad264785");
			p.setUsername("test@gmail.com");
			p.setNom("Hamid");
			p.setPrenom("Haddri");
			p.setEmail("test@gmail.com");
			p.setPassword("emsi123");
			p.setTel(654785);
			Conducteur p3=new Conducteur();
			p3.setCin("ad264785");
			p3.setUsername("kehelbrahim@gmail.com");
			p3.setNom("Kehel");
			p3.setPrenom("Ibrahim");
			p3.setEmail("kehelbrahim@gmail.com");
			p3.setPassword("emsi123");
			p3.setMarque("GOLF");
			p3.setNb_places(5);
			p3.setTel(654785);
			Passager p4=new Passager();
			p4.setCin("ad264785");
			p4.setUsername("mouaddinebasma2@gmail.com");
			p4.setNom("mouaddine");
			p4.setPrenom("Basma");
			p4.setEmail("mouaddinebasma2@gmail.com");
			p4.setPassword("emsi123");
			p4.setTel(654785);
			Passager p5=new Passager();
			p5.setCin("ad264785");
			p5.setUsername("tazinouhaila07@gmail.com");
			p5.setNom("Tazi");
			p5.setPrenom("Nouhaila");
			p5.setEmail("tazinouhaila07@gmail.com");
			p5.setPassword("emsi123");
			p5.setTel(654785);
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
			c.setApprouved(false);
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
			c2.setApprouved(false);

			AppUser admin=new AppUser();
			admin.setCin("ad264785");
			admin.setUsername("admin@gmail.com");
			admin.setNom("hamali");
			admin.setPrenom("Hamid");
			admin.setEmail("admin@gmail.com");
			admin.setPassword("emsi123");
			admin.setTel(654785);
			utilisateurServiceImpl.saveUser(admin,null,null,null);
			utilisateurServiceImpl.addRoleToUser("admin@gmail.com","ROLE_Admin");

			utilisateurServiceImpl.saveUser(p,null,null,null);
			utilisateurServiceImpl.saveUser(p1,null,null,null);
			utilisateurServiceImpl.saveUser(p2,null,null,null);
			utilisateurServiceImpl.saveUser(p3,null,null,null);
			utilisateurServiceImpl.saveUser(p4,null,null,null);
			utilisateurServiceImpl.saveUser(p5,null,null,null);
			utilisateurServiceImpl.saveUser(c,null,null,null);
			utilisateurServiceImpl.saveUser(c1,null,null,null);
			utilisateurServiceImpl.saveUser(c2,null,null,null);
		};
	}
}

package com.emsi.gowithus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="utilisateur_type")
@Data @NoArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cin;
	@Length(min = 5, message = "Le nom d'utilisateur doit contenir au moins 5 caractères")
	@NotEmpty(message = "*SVP entrez un USERNAME")
	private String username;
	private String nom;
	private String prenom;	
	private String email;
	@Length(min = 5, message = "Le mot de passe doit contenir au moins 6 caractères")
	@NotEmpty(message = "*SVP entrez un USERNAME")
	private String password;
	private int tel;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles=new ArrayList<Role>();
}
package com.emsi.gowithus.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="utilisateur_type")
@Data @NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cin;
	@Length(min = 5, message = "Le nom d'utilisateur doit contenir au moins 5 caractères")
	@NotEmpty(message = "*SVP entrez un nom d'utilisateur")
	private String username;
	private String nom;
	private String prenom;	
	private String email;
	@Length(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
	@NotEmpty(message = "*SVP entrez un mot de passe")
	private String password;
	private int tel;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "App_user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles=new ArrayList<Role>();
}

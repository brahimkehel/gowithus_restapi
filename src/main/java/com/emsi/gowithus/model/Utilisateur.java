package com.emsi.gowithus.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="utilisateur_type")
@Data @NoArgsConstructor
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int tel;
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Role> utilisateur_roles;
}

package com.emsi.gowithus.model;

import lombok.Data;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("conducteur")
@Data
public class Conducteur extends AppUser {
	private String marque;
	private int nb_places;
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Annonce> annonces;
}

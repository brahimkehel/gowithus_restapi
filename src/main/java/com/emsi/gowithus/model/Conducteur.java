package com.emsi.gowithus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("conducteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur extends AppUser {
	private String marque;
	private int nb_places;
	private boolean approuved;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "conducteur")
	private List<Annonce> annonces=new ArrayList<>();

	public void addAnnonce(Annonce a) {
		this.annonces.add(a);
		a.setConducteur(this);
	}
}

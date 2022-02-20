package com.emsi.gowithus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("conducteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur extends AppUser {
	private String marque;
	private int nb_places;
	private boolean approuved;
	private String carteGrise;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "conducteur")
	private List<Annonce> annonces=new ArrayList<>();

	public void addAnnonce(Annonce a) {
		this.annonces.add(a);
		a.setConducteur(this);
	}
}

package com.emsi.gowithus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String depart;
	private String arrive;
	private float prix;
	@ToString.Exclude
	@JsonIgnoreProperties("annonces")

	@ManyToOne
	private Conducteur conducteur;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "annonce")
	private List<Reservation> reservations;
}

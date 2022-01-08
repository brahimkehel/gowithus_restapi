package com.emsi.gowithus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String depart;
	private String arrive;
	private float prix;
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Reservation> reservations;
}

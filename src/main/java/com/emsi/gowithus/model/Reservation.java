package com.emsi.gowithus.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float prix;
	@ToString.Exclude
	@JsonIgnoreProperties("reservations")
	@ManyToOne
	private Annonce annonce;
}

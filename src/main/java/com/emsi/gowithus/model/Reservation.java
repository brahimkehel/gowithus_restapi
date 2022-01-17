package com.emsi.gowithus.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float prix;
	@JsonIgnoreProperties("reservations")
	@ToString.Exclude
	@ManyToOne
	private Passager passager;
	@ToString.Exclude
	@ManyToOne
	private Annonce annonce;
}

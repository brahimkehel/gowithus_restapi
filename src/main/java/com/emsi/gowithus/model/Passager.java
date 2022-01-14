package com.emsi.gowithus.model;

import javax.persistence.DiscriminatorValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DiscriminatorValue("Passager")
public class Passager  extends AppUser{
	
}
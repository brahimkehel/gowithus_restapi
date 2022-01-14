package com.emsi.gowithus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Passager")
public class Passager  extends AppUser{
}

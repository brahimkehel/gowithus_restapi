package com.emsi.gowithus.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("Passager")
@NoArgsConstructor
public class Passager  extends AppUser{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "passager")
    private List<Reservation> reservations=new ArrayList<>();

    public void addReservation(Reservation r){
        reservations.add(r);
        r.setPassager(this);
    }
}
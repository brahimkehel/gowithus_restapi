package com.emsi.gowithus.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("Passager")
@NoArgsConstructor
@AllArgsConstructor
public class Passager  extends AppUser{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "passager")
    private List<Reservation> reservations=new ArrayList<>();

    public void addReservation(Reservation r){
        reservations.add(r);
        r.setPassager(this);
    }
}
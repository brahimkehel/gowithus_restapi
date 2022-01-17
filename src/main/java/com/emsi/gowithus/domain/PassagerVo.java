package com.emsi.gowithus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PassagerVo {
    private List<ReservationVo> reservations=new ArrayList<>();
}

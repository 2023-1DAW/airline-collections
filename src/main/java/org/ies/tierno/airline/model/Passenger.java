package org.ies.tierno.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Passenger {
    private String nif;
    private Integer seatNumber;
    private List<Luggage> luggages;
}

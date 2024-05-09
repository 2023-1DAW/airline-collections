package org.ies.tierno.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Flight {
    private int number;
    private String origin;
    private String destination;
    private Date date;
    private TreeSet<Passenger> passengers;
}

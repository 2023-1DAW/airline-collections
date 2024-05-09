package org.ies.tierno.airline.model.comparators;

import org.ies.tierno.airline.model.Passenger;

import java.util.Comparator;

public class ByNifPassengerComparator implements Comparator<Passenger> {

    @Override
    public int compare(Passenger o1, Passenger o2) {
        return o1.getNif().compareTo(o2.getNif());
    }
}

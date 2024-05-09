package org.ies.tierno.airline.model.comparators;

import org.ies.tierno.airline.model.Passenger;

import java.util.Comparator;

public class BySeatNumberPassengerComparator implements Comparator<Passenger> {

    @Override
    public int compare(Passenger o1, Passenger o2) {
        int compare = o1.getSeatNumber().compareTo(o2.getSeatNumber());
        if(compare == 0) {
            compare = o1.getNif().compareTo(o2.getNif());
        }
        return compare;
    }
}

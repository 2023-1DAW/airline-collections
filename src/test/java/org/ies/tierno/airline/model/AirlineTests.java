package org.ies.tierno.airline.model;

import com.sun.source.util.Trees;
import org.ies.tierno.airline.model.comparators.ByNifPassengerComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AirlineTests {

    private Airline airline = createAirline();


    @Test
    public void getFlightPassengersTest() {
        Set<Passenger> passengers = airline.getFlightPassengers(1);


        var passengers1 = new TreeSet<Passenger>(new ByNifPassengerComparator());
        passengers1.add(
                new Passenger(
                        "001",
                        1,
                        List.of(
                                new Luggage(1, "Maleta roja")
                        )
                )
        );
        passengers1.add(
                new Passenger(
                        "002",
                        2,
                        List.of(
                                new Luggage(2, "Maleta azul")
                        )
                )
        );

        Assert.assertEquals(passengers1, passengers);
    }

    @Test
    public void getFlightPassengersFlightNotExistTest() {
        Set<Passenger> passengers = airline.getFlightPassengers(-1);

        Assert.assertNull(passengers);
    }


    private Airline createAirline() {
        Map<Integer, Flight> flights = new HashMap<>();

        var passengers1 = new TreeSet<Passenger>(new ByNifPassengerComparator());
        passengers1.add(
                new Passenger(
                        "001",
                        1,
                        List.of(
                                new Luggage(1, "Maleta roja")
                        )
                )
        );
        passengers1.add(
                new Passenger(
                        "002",
                        2,
                        List.of(
                                new Luggage(2, "Maleta azul")
                        )
                )
        );

        flights.put(
                1,
                new Flight(
                        1,
                        "Madrid",
                        "Barcelona",
                        new Date(),
                        passengers1
                )
        );

        var passengers2 = new TreeSet<Passenger>(new ByNifPassengerComparator());
        passengers2.add(
                new Passenger("001", 10, List
                        .of(
                                new Luggage(3, "Maleta roja")
                        )
                )
        );

        flights.put(
                2,
                new Flight(
                        2,
                        "Barcelona",
                        "Madrid",
                        new Date(),
                        passengers2
                )
        );

        return new Airline(
                "Aerolínea del IES",
                flights,
                List.of(
                        new Customer("001", "Bob", "Esponja"),
                        new Customer("002", "Peppa", "Pig")
                )
        );
    }
}

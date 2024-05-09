package org.ies.tierno.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Map<Integer, Flight> flightsByNumber;
    private List<Customer> customers;


    public Set<Passenger> getFlightPassengers(int flightNumber) {
        if (flightsByNumber.containsKey(flightNumber)) {
            return flightsByNumber
                    .get(flightNumber)
                    .getPassengers();
        } else {
            return null;
        }
    }

    public List<Customer> findFlightCustomers(int flightNumber) {
        Set<Passenger> passengers = getFlightPassengers(flightNumber);
        if (passengers != null) {
//           return passengers
//                    .stream()
//                    .map(passenger -> findCustomer(passenger.getNif()))
//                    ).collect(Collectors.toList());
            List<Customer> flightCustomers = new ArrayList<>();
            for (var passenger : passengers) {
                flightCustomers.add(findCustomer(passenger.getNif()));
            }
            return flightCustomers;
        } else {
            return null;
        }
    }

    private Customer findCustomer(String nif) {
        for (var customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> findCustomersBySurname(String surname) {
        return customers
                .stream()
                .filter(c -> c.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    public Integer getPassengerSeatNumber(int flightNumber, String nif) {
        if(flightsByNumber.containsKey(flightNumber)) {
            Flight flight = flightsByNumber.get(flightNumber);
            for(var passenger: flight.getPassengers()) {
                if(passenger.getNif().equals(nif)) {
                    return passenger.getSeatNumber();
                }
            }
        }
        return null;
    }


    public void addLuggage(int flightNumber, String nif, Luggage luggage) {
        if(flightsByNumber.containsKey(flightNumber)) {
            Flight flight = flightsByNumber.get(flightNumber);
            for(var passenger: flight.getPassengers()) {
                if(passenger.getNif().equals(nif)) {
                    passenger.getLuggages().add(luggage);
                }
            }
        }
    }

    public List<Flight> getPassengerFlights(String nif) {
        return flightsByNumber
                .values()
                .stream()
                .filter(f -> f
                        .getPassengers()
                        .stream()
                        .anyMatch(p -> p.getNif().equals(nif)))
                .collect(Collectors.toList());
    }
}

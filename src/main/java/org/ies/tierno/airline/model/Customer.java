package org.ies.tierno.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String nif;
    private String name;
    private String surname;
}

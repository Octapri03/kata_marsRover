package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Objective {
    private Location location;

    public Objective(Location location) {
        this.location = location;
    }
}

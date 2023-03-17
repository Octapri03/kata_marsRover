package org.example;

public class East implements Orientation {
    @Override
    public Location move(char input) {
        if (input == 'F')
            return new Location(1,0);

        if (input == 'B')
            return new Location(-1, 0);

        return new Location(0,0);
    }
}

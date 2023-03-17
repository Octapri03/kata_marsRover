package org.example;

public class South implements Orientation {
    @Override
    public Location move(char input) {
        if (input == 'F')
            return new Location(0,-1);

        if (input == 'B')
            return new Location(0,1);

        return new Location(0,0);
    }
}

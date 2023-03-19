package org.example;

public class West implements Orientation {
    @Override
    public Location move(char input) {

        if (input == 'F')
            return new Location(-1,0);

        if (input == 'B')
            return new Location(1,0);

        return new Location(0,0);
    }

    @Override
    public Orientation rotate(char input){
        if (input == 'R')
            return new North();

        if (input == 'L')
            return new South();

        return new West();
    }
}

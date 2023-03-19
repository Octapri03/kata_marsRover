package org.example;

public class North implements Orientation {
    @Override
    public Location move(char input) {

        if (input == 'F')
            return new Location(0,1);

        if (input == 'B')
            return new Location(0,-1);

        return new Location(0,0);
    }

    @Override
    public Orientation rotate(char input){
        if (input == 'R')
            return new East();

        if (input == 'L')
            return new West();

        return new North();
    }
}

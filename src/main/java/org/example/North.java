package org.example;

public class North implements Orientation {
    @Override
    public Location forward() {
        return new Location(0,1);
    }

    @Override
    public Location backward() {
        return new Location(0,-1);
    }

    @Override
    public Orientation left(){
        return new West();
    }

    @Override
    public Orientation right(){
        return new East();
    }
}

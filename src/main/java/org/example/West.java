package org.example;

public class West implements Orientation {
    @Override
    public Location forward() {
        return new Location(-1,0);
    }

    @Override
    public Location backward() {
        return new Location(1,0);
    }

    @Override
    public Orientation left(){
        return new South();
    }

    @Override
    public Orientation right(){
        return new North();
    }
}

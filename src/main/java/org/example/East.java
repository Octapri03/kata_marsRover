package org.example;

public class East implements Orientation {
    @Override
    public Location forward() {
        return new Location(1,0);
    }

    @Override
    public Location backward() {
        return new Location(-1,0);
    }

    @Override
    public Orientation left(){
        return new North();
    }

    @Override
    public Orientation right(){
        return new South();
    }
}

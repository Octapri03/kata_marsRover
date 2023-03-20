package org.example;

public class South implements Orientation {
    @Override
    public Location forward() {
        return new Location(0,-1);
    }

    @Override
    public Location backward() {
        return new Location(0,1);
    }

    @Override
    public Orientation left(){
        return new East();
    }

    @Override
    public Orientation right(){
        return new West();
    }

}

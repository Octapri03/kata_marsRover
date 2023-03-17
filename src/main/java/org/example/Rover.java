package org.example;

public class Rover {
    Location location;
    Orientation orientation;
    char[] commands;

    public Rover(Location location, Orientation orientation) {
        this.location = location;
        this.orientation = orientation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public char[] getCommands() {
        return commands;
    }

    public void setCommands(char[] commands) {
        this.commands = commands;
    }

    public void moveRover(char input){
        Location moveLocation = orientation.move(input);
        location.setPosX(location.posX+moveLocation.posX);
        location.setPosY(location.posY+moveLocation.posY);
    }


}

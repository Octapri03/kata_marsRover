package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    int posX;
    int posY;

    public Location(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void changeLocation(Location newLocation){
        this.posX += newLocation.getPosX();
        this.posY += newLocation.getPosY();
    }

    @Override
    public String toString() {
        return "posX=" + posX +
                ", posY=" + posY;
    }
}

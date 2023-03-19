package org.example;

public class Rover {
    Location location;
    Mars mars;
    Orientation orientation;
    char[] commands;

    public Rover(Location location, Orientation orientation, Mars mars) {
        this.location = location;
        this.orientation = orientation;
        this.mars = mars;
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

    public Mars getMars() {
        return mars;
    }

    public void setMars(Mars mars) {
        this.mars = mars;
    }

    public void moveRover(char[] inputArray){
        for (char input: inputArray) {
            if (input == 'F' || input == 'B'){
                Location moveLocation = orientation.move(input);
                if (checkObstacles(moveLocation)){
                    System.out.println("Can't move any further, there's an obstacle near ("+(moveLocation.getPosX()+getLocation().getPosX())+","+(moveLocation.getPosY()+getLocation().getPosY())+")");
                    return;
                }
                location.setPosX(location.posX+moveLocation.posX);
                location.setPosY(location.posY+moveLocation.posY);
                checkBorders();
            }
            if (input == 'R' || input == 'L'){
                Orientation rotateOrientation = orientation.rotate(input);
                setOrientation(rotateOrientation);
            }
        }
    }

    private void checkBorders(){
        if (location.getPosX() == mars.getWidth()+1){
            location.setPosX(0);
        }

        if (location.getPosX() == -1){
            location.setPosX(mars.getWidth());
        }

        if (location.getPosY() == mars.getHeight()+1){
            location.setPosY(0);
        }

        if (location.getPosY() == -1){
            location.setPosX(mars.getHeight());
        }
    }

    private boolean checkObstacles(Location targetLocation){


        for (Obstacle obstacle: getMars().getObstacles()) {
            boolean targetLocationHasObstacle = (targetLocation.getPosX()+getLocation().getPosX() == obstacle.getLocation().getPosX() && targetLocation.getPosY()+getLocation().getPosY() == obstacle.getLocation().getPosY());

            if (targetLocationHasObstacle){
                return true;
            }
        }
        return false;
    }


}

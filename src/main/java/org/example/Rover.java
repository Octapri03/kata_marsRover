package org.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rover {
    private Location location;
    private Mars mars;
    private Orientation orientation;
    private char[] commands;

    public Rover(Location location, Orientation orientation, Mars mars) {
        this.location = location;
        this.orientation = orientation;
        this.mars = mars;
    }

    public void moveRover(char[] inputArray){
        for (char input: inputArray) {
            if (input == 'F'){
                if (checkObstacles(orientation.forward())) return;
                location.changeLocation(orientation.forward());
                checkBorders();
            }

            if (input == 'B'){
                if (checkObstacles(orientation.backward())) return;
                location.changeLocation(orientation.backward());
                checkBorders();
            }

            if (input == 'R'){
                setOrientation(orientation.right());
            }

            if (input == 'L'){
                setOrientation(orientation.left());
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
            location.setPosY(mars.getHeight());
        }
    }

    private boolean checkObstacles(Location targetLocation){


        for (Obstacle obstacle: getMars().getObstacles()) {
            boolean targetLocationHasObstacle = (targetLocation.getPosX()+getLocation().getPosX() == obstacle.getLocation().getPosX() && targetLocation.getPosY()+getLocation().getPosY() == obstacle.getLocation().getPosY());

            if (targetLocationHasObstacle){
                System.out.println("An obstacle has been encountered");
                return true;
            }
        }
        return false;
    }

    public void sonar(){
        char[][] map = new char[mars.getWidth()][mars.getHeight()];
        for (int i = mars.getHeight()-1; i >= 0; i--) {
            for (int j = 0; j < mars.getWidth(); j++) {
                if (getLocation().getPosX() == j && getLocation().getPosY() == i){
                    map[i][j] = 'R';
                }
                else{
                    for (Obstacle obstacle: getMars().getObstacles()) {
                        if (obstacle.getLocation().getPosX()==j && obstacle.getLocation().getPosY()==i)
                            map[i][j] = 'O';
                    }
                    if (getMars().getObjective().getLocation().getPosX() == j && getMars().getObjective().getLocation().getPosY() == i)
                        map[i][j] = 'M';
                    if (map[i][j] == 0)
                        map[i][j] = '·';
                }
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }


}

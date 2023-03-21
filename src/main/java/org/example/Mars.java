package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Setter
@Getter
public class Mars {
    int width;
    int height;

    ArrayList<Obstacle> obstacles;

    Objective objective;

    public Mars(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new ArrayList<>();
        //createObstacles();
    }

    public void createObstacles(){
        Random rand = new Random();
        ArrayList<Obstacle> obstacles = new ArrayList<>();

        for (int i = 0; i < getWidth(); i++){
            int posX = rand.nextInt(getWidth());
            int posY = rand.nextInt(getHeight());

            obstacles.add(new Obstacle(new Location(posX, posY)));
        }
        setObstacles(obstacles);
    }

    public void createObjective(Rover rover){
        objective = new Objective(new Location(rover.getLocation().getPosX(), getHeight()-2));
    }

}

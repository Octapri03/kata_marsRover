package org.example;

import java.util.ArrayList;
import java.util.Random;


public class Mars {
    int width;
    int height;

    ArrayList<Obstacle> obstacles;

    public Mars(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new ArrayList<>();
        //createObstacles();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
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

}

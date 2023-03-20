package org.example;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class AppTest 
{
    @Test
    public void test_roverGoesForwardHeadingNorth()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'F'};
        Rover rover=new Rover(new Location(0,0),new North(), mars);
        rover.moveRover(commands);
        Assert.assertEquals(1, rover.getLocation().getPosY());
    }

    @Test
    public void test_roverGoesBackwardsHeadingNorth()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'B'};
        Rover rover=new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(-1, rover.getLocation().getPosY());
    }

    @Test
    public void test_roverRotatesLeft()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'L'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(West.class, rover.getOrientation().getClass());
    }

    @Test
    public void test_roverRotatesRight()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'R'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(East.class, rover.getOrientation().getClass());
    }

    @Test
    public void test_roverRotatesRightAndGoesForward()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'R', 'F'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(1, rover.getLocation().getPosX());
    }

    @Test
    public void test_roverRotatesRightAndGoesBackwards()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'R', 'B'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(5, rover.getLocation().getPosX());
    }

    @Test
    public void test_roverRotatesLeftAndGoesForward()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'L', 'F'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(5, rover.getLocation().getPosX());
    }

    @Test
    public void test_roverRotatesLeftAndGoesBackwards()
    {
        Mars mars = new Mars(5,5);
        char[] commands = {'L', 'B'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(1, rover.getLocation().getPosX());
    }

    @Test
    public void test_encounterObstacle(){
        Mars mars = new Mars(5,5);
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(new Location(0,1)));
        mars.setObstacles(obstacles);

        char[] commands = {'R','F','L','F','L','F', 'F','L','F'};
        Rover rover = new Rover(new Location(0,0),new North(),mars);
        rover.moveRover(commands);
        Assert.assertEquals(1, rover.getLocation().getPosY());
    }

}

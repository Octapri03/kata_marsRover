package org.example;


import org.junit.Assert;
import org.junit.Test;


public class AppTest 
{
    @Test
    public void test_roverGoesForwardHeadingNorth()
    {
        Rover rover=new Rover(new Location(0,0),new North());
        rover.moveRover('F');
        Assert.assertEquals(1, rover.getLocation().getPosY());
    }
    @Test
    public void test_roverGoesForwardHeadingSoutch()
    {
        Rover rover=new Rover(new Location(0,0),new South());
        rover.moveRover('F');
        Assert.assertEquals(-1, rover.getLocation().getPosY());
    }
}

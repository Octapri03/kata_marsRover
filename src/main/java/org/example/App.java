package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner teclado = new Scanner(System.in);
        boolean startGame = true;
        boolean incorrectCommands = true;
        boolean game = false;
        String commands = "";
        int attempts = 5;
        int attemptsLeft = attempts;
        Rover rover = new Rover(new Location(2,0), new North(), new Mars(5,5));
        rover.getMars().createObstacles();
        rover.getMars().createObjective(rover);

        while (startGame){
            System.out.println("###############################");
            System.out.println("------TIME TO INVADE MARS------");
            System.out.println("###############################");
            System.out.println();
            System.out.println("press F to start playing || press Q to quit");
            String play = teclado.nextLine();
            if (play.equals("F")){
                startGame = false;
                game = true;
            }
            else if (play.equals("Q")) return;
        }


        while (game){
            rover.sonar();
            for (int i = 0; i < attempts; i++) {

                System.out.println("Insert 3 commands in a String in order to get to the oil rig without hitting any obstacles, imperialism must prevail");
                System.out.println("F forward || B backwards || L turn left || R turn Right");
                System.out.println("Attempts left: "+attemptsLeft);
                System.out.println();
                while(incorrectCommands){
                    System.out.print("Commands: ");
                    commands = teclado.nextLine();
                    if (commands.length() <= 3) break;
                    else System.out.println("You can only input 3 commands");
                }


                char[] commandsArray = commands.toCharArray();

                rover.moveRover(commandsArray);
                System.out.println(rover.getLocation().toString());
                rover.sonar();

                attemptsLeft--;
                if (rover.getLocation().getPosY() == rover.getMars().getObjective().getLocation().getPosY() && rover.getLocation().getPosX() == rover.getMars().getObjective().getLocation().getPosX()){
                    //rover.sonar();
                    System.out.println("-----LEVEL COMPLETED-----");
                    System.out.println("The rover made it to the oil rig safely, imperialism prevails");
                    return;
                }
            }

            //rover.sonar();
            System.out.println("----- GAME OVER -----");
            System.out.println("The rover didn't make it the oil rig");
            game = false;
        }

    }
}

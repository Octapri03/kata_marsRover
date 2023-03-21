package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner teclado = new Scanner(System.in);
        boolean startGame = true;
        boolean game = false;
        Rover rover = new Rover(new Location(2,0), new North(), new Mars(5,5));
        rover.getMars().createObstacles();

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
            System.out.println("Insert the commands in a String in order to get to the top without hitting any obstacles");
            System.out.println("F forward || B backwards || L turn left || R turn Right");
            System.out.print("Commands: ");
            String commands = teclado.nextLine();

            char[] commandsArray = commands.toCharArray();

            rover.moveRover(commandsArray);

            if (rover.getLocation().getPosY() == rover.getMars().getHeight()-1){
                rover.sonar();
                System.out.println("-----LEVEL COMPLETED-----");
                System.out.println("The rover made it to the other side safely");
            }
            else {
                rover.sonar();
                System.out.println("----- GAME OVER -----");
                System.out.println("The rover didn't make it the other side");
            }
            game = false;
        }





        /*Mars mars = new Mars(5,5);
        char[] commands = {'F'};
        boolean desplegar = true;
        Scanner teclado = new Scanner(System.in);
        int numRovers = 0;
        ArrayList<Rover> rovers = new ArrayList<>();

        int posInitX;



        while(desplegar){
            System.out.println("Introduce el número de Rovers que quieres desplegar:");
            numRovers = teclado.nextInt();

            for (int i = 0; i < numRovers; i++) {
                rovers.add(new Rover(new Location(0,0), new North(), mars));
            }

            for (Rover rover: rovers) {
                System.out.println("Introduce la cordenada x del rover");

                System.out.println("Introduce la cordenada y del rover");
                System.out.println("Introduce la orientacion del rover (N, S, W, E)");

                rover.moveRover(commands);
            }

        }*/
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Mars mars = new Mars(5,5);
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

        }
    }
}

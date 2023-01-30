package Client;

import java.rmi.Naming;
import java.util.Scanner;

import Common.Simulation;

public class Client {

    // private field to store user choise for menu
    private static int choise;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // looking for the stub with the name given in server
            Simulation stub = (Simulation) Naming.lookup("localhost");

            System.out.println("=======================");
            System.out.println("Connected to the Server");
            System.out.println("=======================");

            while (true) {
                // displaying the menu
                System.out.println("-----------------------------------");
                System.out.println("What would you like to do next?");
                System.out.println("1. Generate random events");
                System.out.println("2. Exit");
                System.out.println("-----------------------------------");

                // checking of the input is valid
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input, please select a valid option");
                    scanner.next();
                    continue;
                }
                choise = scanner.nextInt();

                // performing actions based on user choise
                switch (choise) {
                    case 1:
                        System.out.println("Enter the number of random events to be genereated:");

                        // checking of the input is valid
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input, please enter a number");
                            scanner.next();
                            continue;
                        }

                        int number = scanner.nextInt();
                        stub.runSimulation(number);
                        System.out.println("Events completed!");
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Thank you for using this application");

                        // exiting the application
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, please select a valid option");
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

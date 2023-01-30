package Server;

import java.rmi.Naming;
import java.util.concurrent.TimeUnit;

import Common.Simulation;

public class Server {

    static Processor p1 = new Processor(1001, 1);
    static Processor p2 = new Processor(1002, 3);
    static Processor p3 = new Processor(1003, 2);
    static Processor p4 = new Processor(1004, 1);

    public static void main(String[] args) {
        try {
            System.out.println("=========================");
            System.out.println("Server Started");

            // creating an instance the class
            Simulation stub = new SimulationImpl();

            // starting the processors
            p1.start();
            p2.start();
            p3.start();
            p4.start();
            TimeUnit.SECONDS.sleep(3);
            System.out.println("=========================");
            System.out.println("");

            // binding the name of the stub 
            Naming.rebind("localhost", stub);
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
        }
    }
}
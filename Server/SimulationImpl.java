package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Common.Simulation;

public class SimulationImpl extends UnicastRemoteObject implements Simulation {

    private int eventCount = 0;

    // creating a constructor
    public SimulationImpl() throws RemoteException {
        super();
    }

    @Override
    public void runSimulation(int number) throws RemoteException {
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 1; i <= number; i++) {
                eventCount++;
                Random ran = new Random();
                int from = ran.nextInt(4) + 1001;
                int to = ran.nextInt(4) + 1001;

                switch (from) {
                    case 1001:
                        TimeUnit.SECONDS.sleep(1);
                        Server.p1.sendMessage();
                        break;
                    case 1002:
                        TimeUnit.SECONDS.sleep(1);
                        Server.p2.sendMessage();
                        break;
                    case 1003:
                        TimeUnit.SECONDS.sleep(1);
                        Server.p3.sendMessage();
                        break;
                    case 1004:
                        TimeUnit.SECONDS.sleep(1);
                        Server.p4.sendMessage();
                        break;
                    default:
                        break;
                }

                Event event = new Event(
                        eventCount,
                        from == 1001 ? Server.p1.getId()
                                : (from == 1002 ? Server.p2.getId()
                                        : (from == 1003 ? Server.p3.getId() : Server.p4.getId())),
                        to == 1001 ? Server.p1.getId()
                                : (to == 1002 ? Server.p2.getId()
                                        : (to == 1003 ? Server.p3.getId() : Server.p4.getId())),
                        from == 1001 ? Server.p1.getCurrentTimeStamp()
                                : (from == 1002 ? Server.p2.getCurrentTimeStamp()
                                        : (from == 1003 ? Server.p3.getCurrentTimeStamp()
                                                : Server.p4.getCurrentTimeStamp())));
                event.printEvent(event);

                switch (to) {
                    case 1001:
                        Server.p1.receiveMessage(event);
                        break;
                    case 1002:
                        Server.p2.receiveMessage(event);
                        break;
                    case 1003:
                        Server.p3.receiveMessage(event);
                        break;
                    case 1004:
                        Server.p4.receiveMessage(event);
                        break;
                    default:
                        break;
                }
            }
            
            System.out.println("==================================================");
            Server.p1.printTimeStamps();
            Server.p2.printTimeStamps();
            Server.p3.printTimeStamps();
            Server.p4.printTimeStamps();
            System.out.println("==================================================");
        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
        }
    }

}

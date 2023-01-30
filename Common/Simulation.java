package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Simulation extends Remote {
    
    void runSimulation(int number) throws RemoteException;
}

package ObjetDistant;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetDistant2 extends Remote {

    void G() throws RemoteException;
    void waitG() throws RemoteException, InterruptedException;

}

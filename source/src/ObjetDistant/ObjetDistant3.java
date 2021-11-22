package ObjetDistant;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetDistant3 extends Remote {

    void E() throws RemoteException;
    void F() throws RemoteException;

    void waitE() throws RemoteException, InterruptedException;
    void waitF() throws RemoteException, InterruptedException;

}

package ObjetDistant;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetDistant1 extends Remote {

    public void C() throws RemoteException;
    public void A() throws RemoteException;
    public void B() throws RemoteException;

    void waitA() throws RemoteException, InterruptedException;
    void waitB() throws RemoteException, InterruptedException;
    void waitC() throws RemoteException, InterruptedException;

}

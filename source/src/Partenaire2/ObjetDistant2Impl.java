package Partenaire2;

import ObjetDistant.ObjetDistant2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant2Impl extends UnicastRemoteObject implements ObjetDistant2 {

    private Boolean gIsDone = false;

    protected ObjetDistant2Impl() throws RemoteException {
    }

    @Override
    public void G() throws RemoteException {
        System.out.println("Methode G");
        gIsDone = true;
        notify();

    }

    @Override
    public void waitG() throws RemoteException, InterruptedException {
        while (!gIsDone){
            wait();
        }
    }
}

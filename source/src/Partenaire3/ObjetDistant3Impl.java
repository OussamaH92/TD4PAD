package Partenaire3;


import ObjetDistant.ObjetDistant2;
import ObjetDistant.ObjetDistant3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant3Impl extends UnicastRemoteObject implements ObjetDistant3 {

    private boolean eIsDone = false;
    private boolean fIsDone = false;

    public ObjetDistant3Impl() throws RemoteException {
    }

    @Override
    public synchronized void E() throws RemoteException {
        System.out.println("E");
        eIsDone = true;
        notify();
    }

    @Override
    public synchronized void F() throws RemoteException {
        System.out.println("F");
        fIsDone = true;
        notify();
    }

    @Override
    public synchronized void waitE() throws RemoteException, InterruptedException {
         while(!eIsDone){
             wait();
         }
    }

    @Override
    public void waitF() throws RemoteException, InterruptedException {
        while(!fIsDone){
            wait();
        }
    }
}

package Parteniare1;

import ObjetDistant.ObjetDistant1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant1Impl extends UnicastRemoteObject implements ObjetDistant1 {

    private boolean cIsDone = false;
    private boolean aIsDone = false;
    private boolean bIsDone = false;


    protected ObjetDistant1Impl() throws RemoteException {
    }

    @Override
    public void C() throws RemoteException {
        System.out.println("C");
    }

    @Override
    public void A() throws RemoteException {
        System.out.println("A");
    }

    @Override
    public void B() throws RemoteException {
        System.out.println("B");
    }

    @Override
    public void waitA() throws RemoteException, InterruptedException {
        while (!aIsDone){
            wait();
        }
    }

    @Override
    public void waitB() throws RemoteException, InterruptedException {
        while (!bIsDone){
            wait();
        }
    }

    @Override
    public void waitC() throws RemoteException, InterruptedException {
        while (!cIsDone){
            wait();
        }
    }
}

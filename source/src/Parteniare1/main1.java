package Parteniare1;

import ObjetDistant.ObjetDistant1;
import ObjetDistant.ObjetDistant2;
import ObjetDistant.ObjetDistant3;
import Partenaire2.ObjetDistant2Impl;
import Partenaire3.ObjetDistant3Impl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class main1 {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, NotBoundException, InterruptedException {

        Registry reg = LocateRegistry.createRegistry(1099);
        ObjetDistant1 od = new ObjetDistant1Impl();
        ObjetDistant2 od2 = null;
        ObjetDistant3 od3 = null;

        reg.rebind("ObjetDistant1",od);

        while(od2 == null) {
            try {
                //od2 = (ObjetDistant2Impl) UnicastRemoteObject.exportObject(od2,0);
                Registry reg2 = LocateRegistry.getRegistry("localhost");
                od2 = (ObjetDistant2) reg2.lookup("ObjetDistant2");

            }catch (Exception e){

            }
        }

        while(od3 == null) {
            try {
                //od3 = (ObjetDistant3Impl) UnicastRemoteObject.exportObject(od3,0);
                Registry reg3 = LocateRegistry.getRegistry("localhost");
                od3 = (ObjetDistant3) reg3.lookup("ObjetDistant3");
            }catch (Exception e){

            }
        }

        Partenaire1 p = new Partenaire1(od,od2,od3);
        p.start();
    }
}

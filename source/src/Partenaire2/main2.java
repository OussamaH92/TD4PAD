package Partenaire2;

import ObjetDistant.ObjetDistant1;
import ObjetDistant.ObjetDistant2;
import ObjetDistant.ObjetDistant3;
import Partenaire3.ObjetDistant3Impl;
import Parteniare1.ObjetDistant1Impl;
import Parteniare1.Partenaire1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class main2 {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException, InterruptedException {

        Registry reg = LocateRegistry.getRegistry("localhost");
        ObjetDistant2 od2 = new ObjetDistant2Impl();
        ObjetDistant1 od = null;
        ObjetDistant3 od3 = null;

        reg.rebind("ObjetDistant2",od2);

        while(od == null) {
            try{
                Registry reg1 = LocateRegistry.getRegistry("localhost");
                od = (ObjetDistant1) reg1.lookup("ObjetDistant1");
            }catch (Exception e){}
        }
        while(od2 == null) {
            try{
                Registry reg3 = LocateRegistry.getRegistry("localhost");
                od3 = (ObjetDistant3) reg3.lookup("ObjetDistant3");
            }catch (Exception e){}
        }

        Partenaire1 p = new Partenaire1(od,od2,od3);
        p.start();

    }
}

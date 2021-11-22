package Partenaire3;

import ObjetDistant.ObjetDistant1;
import ObjetDistant.ObjetDistant2;
import ObjetDistant.ObjetDistant3;
import Partenaire2.ObjetDistant2Impl;
import Parteniare1.ObjetDistant1Impl;
import Parteniare1.Partenaire1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class main3 {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException, InterruptedException {
        Registry reg = LocateRegistry.getRegistry("localhost");

        ObjetDistant3 od3 = new ObjetDistant3Impl();
        ObjetDistant2 od2 = null;
        ObjetDistant1 od = null;

        reg.rebind("ObjetDistant3",od3);

        while(od == null) {
            try{
                Registry reg1 = LocateRegistry.getRegistry("localhost");
                od = (ObjetDistant1) reg1.lookup("ObjetDistant1");
            }catch (Exception e){}
        }
        while(od2 == null) {
            try{
                Registry reg2 = LocateRegistry.getRegistry("localhost");
                od2 = (ObjetDistant2)  reg2.lookup("ObjetDistant2");
            }catch (Exception e){}
        }

        Partenaire1 p = new Partenaire1(od,od2,od3);
        p.start();
    }
}

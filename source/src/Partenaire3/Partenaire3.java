package Partenaire3;

import ObjetDistant.ObjetDistant1;
import ObjetDistant.ObjetDistant2;
import ObjetDistant.ObjetDistant3;
import Partenaire2.ObjetDistant2Impl;
import Parteniare1.ObjetDistant1Impl;

import java.rmi.RemoteException;

public class Partenaire3{

    private ObjetDistant1 od1;
    private ObjetDistant2 od2;
    private ObjetDistant3 od3;

    public Partenaire3(ObjetDistant1 od1, ObjetDistant2 od2, ObjetDistant3 od3) {
        this.od1 = od1;
        this.od2 = od2;
        this.od3 = od3;
    }

    public void start() throws RemoteException, InterruptedException {

        od1.waitA();
        od1.B();
        od3.waitE();
        od2.waitG();
        od1.C();
        od3.waitF();


    }
}

package Partenaire2;

import ObjetDistant.ObjetDistant1;
import ObjetDistant.ObjetDistant2;
import ObjetDistant.ObjetDistant3;
import Partenaire3.ObjetDistant3Impl;
import Parteniare1.ObjetDistant1Impl;

import java.rmi.RemoteException;

public class Partenaire2 {

    private ObjetDistant1 od1;
    private ObjetDistant2 od2;
    private ObjetDistant3 od3;

    public Partenaire2(ObjetDistant1 od1, ObjetDistant2 od2, ObjetDistant3 od3) {
        this.od1 = od1;
        this.od2 = od2;
        this.od3 = od3;
    }

    public void start() throws RemoteException, InterruptedException {

        od1.A();
        od1.waitB();
        od3.E();
        od2.waitG();
        od1.waitC();
        od3.F();

    }
}

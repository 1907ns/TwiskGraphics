package twisk.tests;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

import java.util.Iterator;

class EtapeIGTest {
        EtapeIG eg, eg2;
        PointDeControleIG p1,p2,p3,p4;

    @BeforeEach
    public void setUp() {
         eg = new ActiviteIG("Ciné","0",10,10);
         eg2 = new ActiviteIG("Plage","1",20,20);
        p1= new PointDeControleIG("0",eg);
        p2=new PointDeControleIG("1",eg);
        p3=new PointDeControleIG("2",eg);
        p4=new PointDeControleIG("3",eg);


    }
    @Test
    void getNomEtape() {
        Assertions.assertTrue(eg.getNomEtape().equals("Ciné"));
        Assertions.assertFalse(eg.getNomEtape().equals("Plage"));
        Assertions.assertTrue(eg2.getNomEtape().equals("Plage"));
        Assertions.assertFalse(eg2.getNomEtape().equals("Ciné"));

    }


    @Test
    void getIdentifiant() {
        Assertions.assertEquals(eg.getIdentifiant(),"0");
        Assertions.assertEquals(eg2.getIdentifiant(),"1");
    }
    @Test
    void testIterator(){

        eg.ajouterPointsDeControle(p1,p2,p3,p4);
        Iterator<PointDeControleIG> ite = eg.iterator();
        assertEquals(ite.next().getId(),"0");
        assertEquals(ite.next().getId(),"1");
        assertEquals(ite.next().getId(),"2");
        assertEquals(ite.next().getId(),"3");
    }
}
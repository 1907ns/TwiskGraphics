package twisk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

class MondeIGTest {
    MondeIG monde;
    @BeforeEach
    public void setUp() {
        monde = new MondeIG();
        monde.ajouter("A");
        monde.ajouter("B");
        monde.ajouter("C");


    }

    @Test
    void ajouterTest(){
        Assertions.assertEquals(monde.getHashEtape().size(),3);

    }

    @Test
    void iteratorTest(){
        MondeIG m = new MondeIG();
        m.ajouter("A");
        m.ajouter("B");
        m.ajouter("C");
        Iterator <EtapeIG> ite = monde.iterator();
        assertEquals(ite.next().getNomEtape(),"A");
        assertEquals(ite.next().getNomEtape(),"B");
        assertEquals(ite.next().getNomEtape(),"C");
        assertEquals(m.getHashEtape().size(),3);

    }

    @Test
    void ajouterVueTest(){

    }


}
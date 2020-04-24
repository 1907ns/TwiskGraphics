package twisk.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.FabriqueIdentifiant;

import static org.junit.jupiter.api.Assertions.*;

class PointDeControleIGTest {

    PointDeControleIG point1,point2,point3;
    EtapeIG etp;
    @BeforeEach
    void setUp() {
        FabriqueIdentifiant fabriqueI = FabriqueIdentifiant.getInstance();
        fabriqueI.setNoEtape(-1);
        etp = new ActiviteIG("Football",fabriqueI.getIdentifiantEtape(),50,50);
        point1= new PointDeControleIG("0",etp);
        point2=new PointDeControleIG("1",etp);
        point3=new PointDeControleIG("2",etp);
    }

    @Test
    void getId() {
        assertEquals(point1.getId(),"0");
        assertEquals(point2.getId(),"1");
        assertEquals(point3.getId(),"2");
    }

    @Test
    void getEtape() {
        assertEquals(point1.getEtape().getNomEtape(),"Football");
        assertEquals(point2.getEtape().getIdentifiant(),"0");
    }
}
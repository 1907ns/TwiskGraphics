package twisk.tests;

import com.sun.javafx.scene.paint.GradientUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.PointDeControleIG;

import static org.junit.jupiter.api.Assertions.*;

class ArcIGTest {
    ArcIG arc;
    PointDeControleIG pt1, pt2;
    EtapeIG etape;
    @BeforeEach
    void setUp() {
        etape = new ActiviteIG("Football","0",10,10);
        pt1= new PointDeControleIG("0",etape);
        pt2= new PointDeControleIG("1",etape);
        arc = new ArcIG(pt1,pt2);
    }

    @Test
    void idPoints(){
        assertEquals(arc.getPt1().getId(),"0");
        assertEquals(arc.getPt2().getId(),"1");
        assertEquals(arc.getPt1().getEtape().getNomEtape(),"Football");
        assertEquals(arc.getPt2().getEtape().getNomEtape(),"Football");
    }

    @Test
    void getPt2() {
    }
}
package twisk.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.outils.FabriqueIdentifiant;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueIdentifiantTest {

    FabriqueIdentifiant fab,fab2,fab3;
    @BeforeEach
    void setUp() {
        fab = FabriqueIdentifiant.getInstance();
        fab2 = FabriqueIdentifiant.getInstance();
        fab3 = FabriqueIdentifiant.getInstance();

    }

    @Test
    void getIdentifiantEtape() {
        Assertions.assertEquals(fab.getInstance().getIdentifiantEtape(),"0");
        Assertions.assertEquals(fab2.getInstance().getIdentifiantEtape(),"1");
        Assertions.assertEquals(fab3.getInstance().getIdentifiantEtape(),"2");
    }



}
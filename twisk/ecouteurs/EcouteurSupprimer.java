package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

/**
 * Ecouteur permettant de supprimer une étape si celle-ci est sélectionnée
 */
public class EcouteurSupprimer implements EventHandler<ActionEvent> {

    private MondeIG mon;
    public EcouteurSupprimer(MondeIG monde){
        this.mon = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Iterator<EtapeIG> ite = mon.iterator();
        Iterator<ArcIG> iteArc=mon.iterateurArc();

        while(ite.hasNext()){
            EtapeIG e= ite.next();
            if(e.getEstSelect()){
                e.retirerPointsDeControle();
                ite.remove();
            }
        }
        while(iteArc.hasNext()) {
            ArcIG a =iteArc.next();
            if(a.getPt1().getEtape().getEstSelect() || a.getPt2().getEtape().getEstSelect() || a.getEstSelect()){
                iteArc.remove();
            }
        }
        mon.notifierObservateurs();
    }
}

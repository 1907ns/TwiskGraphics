package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

/**
 * Ecouteur permettant de déselectionner
 * tous les composants graphiques sélectionnés
 */
public class EffacerSelection implements EventHandler<ActionEvent> {
    private MondeIG mondeIG;
    public EffacerSelection(MondeIG mon){
        this.mondeIG=mon;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Iterator<EtapeIG> ite = mondeIG.iterator();
        Iterator<ArcIG> iteArc=mondeIG.iterateurArc();

        while(ite.hasNext()){
            EtapeIG e= ite.next();
            if(e.getEstSelect()){
                e.setEstSelect(false);
            }
        }
        while(iteArc.hasNext()) {
            ArcIG a =iteArc.next();
            if(a.getEstSelect()){
                a.setEstSelect(false);
            }
        }
        this.mondeIG.notifierObservateurs();
    }
}

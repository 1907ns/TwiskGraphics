package twisk.ecouteurs;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.vues.Observateur;
import java.util.Iterator;


/**
 * Ecouteur de l'item permettant de
 * set les sorties du mondeIG
 */
public class EcouteurSortie implements EventHandler<ActionEvent>, Observateur {
    private MondeIG mondeIG;

    public EcouteurSortie(MondeIG monde){
        this.mondeIG=monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Iterator<EtapeIG> ite = mondeIG.iterator();
        Iterator<ArcIG> iteArc = mondeIG.iterateurArc();
        if(mondeIG.getListEtapeSlct().size()==1){//permission de désigner en sortie si on a sélectionné une seule étape
            while(ite.hasNext()){
                EtapeIG e = ite.next();
                if(e.getEstSelect() && !e.getSortie()){
                    e.setSortie(true);

                }else if(e.getSortie() && e.getEstSelect() ){
                    e.setSortie(false);
                    ite.remove();
                    this.mondeIG.getListeSorties().remove(e);
                    while(iteArc.hasNext()) {
                        ArcIG a =iteArc.next();
                        if(a.getPt1().getEtape().getSortie() || a.getPt2().getEtape().getSortie()){
                            iteArc.remove();
                        }
                    }
                }

            }
            this.mondeIG.aCommeSortie();
        }else{
            PauseTransition pause = new PauseTransition(Duration.seconds(6));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception");
            alert.setContentText("Veuilez sélectionner une seule étape");
            alert.show();
            pause.setOnFinished(event ->
                    alert.close());
            pause.play();
        }

        this.mondeIG.notifierObservateurs();
    }

    @Override
    public void reagir() {

    }
}
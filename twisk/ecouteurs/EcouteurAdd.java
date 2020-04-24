package twisk.ecouteurs;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

/**
 * Ecouteur du bouton permettant d'ajouter une étape dans le monde
 */
public class EcouteurAdd implements EventHandler<ActionEvent> {
    private MondeIG mon;

    public EcouteurAdd(MondeIG monde){
        this.mon = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.mon.ajouter("Etape");
    }
}

package twisk.ecouteurs;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.vues.*;

import java.util.Iterator;
import java.util.Optional;

/**
 * Ecouteur permettant de renommer une étape en la sélectionnant
 */
public class EcouteurRenommer implements EventHandler<ActionEvent>, Observateur {
    private MondeIG monde;
    public EcouteurRenommer(MondeIG monde){
        this.monde = monde;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if(monde.getListEtapeSlct().size()==1){ //permission de renommer si on a sélectionné une seule étape
            TextInputDialog dialog = new TextInputDialog("Renommer étape");
            dialog.setTitle("Modification nom étape");
            dialog.setContentText("Renommer:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                monde.getListEtapeSlct().get(0).setNom(name);
            });
            this.monde.notifierObservateurs();
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

    }

    @Override
    public void reagir() {

    }
}

package twisk.ecouteurs;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.util.Duration;
import twisk.mondeIG.MondeIG;

import java.util.Optional;


/**
 * Ecouteur du MenuItem permettant
 * de set le temps de l'activitéIG
 */
public class EcouteurTemps implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurTemps(MondeIG monde){
        this.monde = monde;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if(monde.getListEtapeSlct().size()==1){ //permission de paramétrer le temps si on a sélectionné une seule étape
            TextInputDialog dialog = new TextInputDialog("Temps étape");
            dialog.setTitle("Régler temps étape");
            dialog.setContentText("Choisir:");
            Optional<String> result = dialog.showAndWait();
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
}

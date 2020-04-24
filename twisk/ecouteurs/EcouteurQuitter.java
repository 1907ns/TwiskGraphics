package twisk.ecouteurs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;

/**
 * Ecouteur du MenuItem permettant de quitter l'application
 */
public class EcouteurQuitter implements EventHandler<ActionEvent> {

    private MondeIG monde;

    public EcouteurQuitter(MondeIG monde){
        this.monde=monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
    }
}

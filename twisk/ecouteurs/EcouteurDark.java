package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueMondeIG;

/**
 * Ecouteur du MenuItem permettant
 * d'imposer le darkMode à la vueMondeIG
 */
public class EcouteurDark implements EventHandler<ActionEvent> {
    private VueMondeIG vueMondeIG;
    private MondeIG mondeIG;
    public EcouteurDark(MondeIG mon,VueMondeIG vm){
        this.mondeIG=mon;
        this.vueMondeIG=vm;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.vueMondeIG.setStyle("-fx-border-color: #ffffff; -fx-background-color: #494949;");
        this.mondeIG.notifierObservateurs();
    }
}

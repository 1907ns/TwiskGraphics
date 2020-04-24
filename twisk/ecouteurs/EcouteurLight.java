package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueMondeIG;


/**
 * Ecouteur du MenuItem permettant
 * d'imposer le lightMode à la vueMondeIG
 */
public class EcouteurLight implements EventHandler<ActionEvent> {
        private VueMondeIG vueMondeIG;
        private MondeIG mondeIG;

        public EcouteurLight(MondeIG mon,VueMondeIG vm){
            this.mondeIG=mon;
            this.vueMondeIG=vm;

        }
        @Override
        public void handle(ActionEvent actionEvent) {
            this.vueMondeIG.setStyle("-fx-border-color: #0059FF; -fx-background-color: #f2d8ff;");
            this.mondeIG.notifierObservateurs();
        }
    }

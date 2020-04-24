package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueEtapeIG;

/**
 * Ecouteur permettant de sélectionner une étape en cliquant sur ce-dernier
 */
public class EcouteurSlcEtape implements EventHandler<MouseEvent> {

    private MondeIG monde;
    private VueEtapeIG vEtape;
    private int compteur;
    private int nbClick;
    public EcouteurSlcEtape(MondeIG monde, VueEtapeIG vEtape){
        this.monde=monde;
        this.vEtape=vEtape;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(nbClick%2==0){
            this.vEtape.setStyle("-fx-border-color: #bcff09; -fx-background-color: #00f9ff;");
            this.monde.ajouterEtapeSlct(this.vEtape.getEtape());
            ++nbClick;
        }

        else if(nbClick%2!=0){
            this.monde.retirerEtapeDeselect(this.vEtape.getEtape());
            this.vEtape.setStyle("-fx-border-color: #0059FF; -fx-background-color: #ffffff;");
            ++nbClick;
        }

    }
}

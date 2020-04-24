package twisk.ecouteurs;


import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.FabriqueIdentifiant;
import twisk.outils.FabriqueNumClique;
import twisk.vues.VuePointDeControleIG;

/**
 * Ecouteur permettant de sélectionner les points de contrôle
 * et, par conséquent, d'ajouter des arcs
 */
public class EcouteurPtControle implements EventHandler<MouseEvent> {
    private VuePointDeControleIG vp;
    private MondeIG mon;


    public EcouteurPtControle(VuePointDeControleIG vp, MondeIG mon){
        this.vp = vp;
        this.mon = mon;
    }

    @Override
    public void handle(MouseEvent actionEvent)  {

        try {
            mon.ptSelectionne(vp.getPoint()); // ajout possible d'un arc
            this.vp.setFill(Color.RED);
            this.vp.getPoint().setEstSelect(true);
        } catch (TwiskException e) {
            PauseTransition pause = new PauseTransition(Duration.seconds(6));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception");
            alert.setContentText(e.getMessage());
            alert.show();
            pause.setOnFinished(event ->
                   alert.close());
          pause.play();
          this.mon.setPtDepart();
            this.vp.setFill(Color.BLACK);
        }
    }


}




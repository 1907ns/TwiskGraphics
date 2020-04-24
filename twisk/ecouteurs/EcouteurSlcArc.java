package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.MondeIG;
import twisk.vues.Observateur;
import twisk.vues.VueArcIG;

/**
 * Ecouteur permettant de sélectionner un arc en cliquant sur ce-dernier
 */
public class EcouteurSlcArc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private VueArcIG vArc;
    private Line line;
    private Polyline pl;
    private int compteur;
    private int nbClick;
    public EcouteurSlcArc(MondeIG monde, VueArcIG vArc, Line line, Polyline p){
        this.monde=monde;
        this.vArc=vArc;
        this.line=line;
        this.pl =p;

    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(nbClick%2==0){
            this.vArc.getArc().setEstSelect(true);
            this.line.setStyle("-fx-stroke: red");
            this.pl.setStyle("-fx-stroke: red");
            ++nbClick;
        }

        else if(nbClick%2!=0){
            this.vArc.getArc().setEstSelect(false);
            this.line.setStyle("-fx-stroke: black");
            this.pl.setStyle("-fx-stroke: black");
            ++nbClick;
        }
    }


}

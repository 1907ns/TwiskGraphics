package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import twisk.ecouteurs.EcouteurPtControle;
import twisk.ecouteurs.EctrDragDropped;
import twisk.ecouteurs.EctrDragOver;
import twisk.mondeIG.*;

import java.util.Iterator;

/**
 * Classe MondeIG
 * Représentant graphique du MondeIG
 */
public class VueMondeIG extends Pane implements Observateur {
    private MondeIG mon;

    /**
     * Constructeur du mondeIG
     * @param monde monde à représenter
     */
    public VueMondeIG (MondeIG monde){
        super();
        this.mon=monde;
        for(EtapeIG e : mon){
            VueEtapeIG veg = new VueActiviteIG(mon,e);
            this.getChildren().add(veg);
        }
        this.setOnDragDropped(new EctrDragDropped(mon,this));
        this.setOnDragOver(new EctrDragOver(this.mon, this));
        this.setStyle("-fx-border-color: #0059FF; -fx-background-color: #f2d8ff;");
        this.mon.ajouterObservateur(this);

    }

    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {
        this.getChildren().clear();
        this.mon.removeAllEtapeDeSelect();
        Iterator<ArcIG> ite = mon.iterateurArc();
        while(ite.hasNext()){
            ArcIG a = ite.next();
            VueArcIG vArc = new VueArcIG(mon,a);
            this.getChildren().add(vArc);
        }
        for(EtapeIG e : mon){
            VueEtapeIG veg = new VueActiviteIG(mon,e);
            this.getChildren().add(veg);
            for(PointDeControleIG p: e){
                VuePointDeControleIG vp = new VuePointDeControleIG(mon,e,p);
                this.getChildren().add(vp);
            }
        }

    }
}

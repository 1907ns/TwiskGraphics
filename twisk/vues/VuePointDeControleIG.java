package twisk.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.ecouteurs.EcouteurAdd;
import twisk.ecouteurs.EcouteurPtControle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

/**
 * Classe VuePointDeControleIG
 * Représentant graphique des points de contrôle de chaque étape
 */
public class VuePointDeControleIG extends Circle implements Observateur {

    private MondeIG monde;
    private EtapeIG etape;
    private PointDeControleIG point;

    /**
     *
     * @param monde monde possédant l'étape en question
     * @param etape étape possédant le point de contrôle à représenter
     * @param point point à représenter
     */
    public VuePointDeControleIG(MondeIG monde, EtapeIG etape, PointDeControleIG point){
        super();
        this.monde=monde;
        this.etape=etape;
        this.point=point;
        this.setCenterX(point.getPosX());
        this.setCenterY(point.getPosY());
        this.setRadius(4);
        this.setFill(Color.BLACK);
        this.setStroke(Color.RED);
        this.setOnMouseClicked(new EcouteurPtControle(this,this.monde));
    }

    /**
     * Getter du point de contrôle à représenter
     * @return le point de contrôle à représenter
     */
    public PointDeControleIG getPoint() {
        return point;
    }

    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {

    }
}

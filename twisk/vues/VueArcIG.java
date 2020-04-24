package twisk.vues;

import javafx.scene.layout.Pane;

import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.ecouteurs.EcouteurSlcArc;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

import java.util.Iterator;

/**
 * Classe VueArcIG
 * Représentant graphique des arcsIG du mondeIG
 */
public class VueArcIG extends Pane implements Observateur {
    private MondeIG monde;
    private ArcIG arc;
    private Line l;

    /**
     * Constructeur de la Vue d'arcIG
     * @param mon MondeIG
     * @param a ArcIG à représenter
     */
   public VueArcIG(MondeIG mon, ArcIG a){
       super();
       monde=mon;
       arc=a;
       this.l = new Line();
       l.setStartX(arc.getPt1().getPosX());
       l.setStartY(arc.getPt1().getPosY());
       l.setEndX(arc.getPt2().getPosX());
       l.setEndY(arc.getPt2().getPosY());
       double ex = l.getEndX();
       double ey = l.getEndY();
       double sx = l.getStartX();
       double sy = l.getStartY();

       Polyline pl1 = new Polyline();
       double angle = Math.atan2((ey - sy), (ex - sx)) - Math.PI / 2.0;
       double sin = Math.sin(angle);
       double cos = Math.cos(angle);
       //point1
       double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * 10.0 + ex;
       double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * 10.0 + ey;
       //point2
       double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * 10.0 + ex;
       double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * 10.0 + ey;

       pl1.getPoints().addAll(x1,y1,ex,ey,x2,y2);
       this.l.setStrokeWidth(3);
       pl1.setStrokeWidth(3);
       this.getChildren().addAll(pl1,l);
       this.l.setOnMouseClicked(new EcouteurSlcArc(monde,this,this.l,pl1));
       this.setPickOnBounds(false);
   }

    /**
     * Getteur de l'arcIG à représenter
     * @return l'arcIG à représenter
     */
    public ArcIG getArc() {
        return arc;
    }

    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {

    }
}

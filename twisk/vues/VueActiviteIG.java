package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.ecouteurs.EcouteurSlcEtape;
import twisk.ecouteurs.EctrDragDetected;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.Sujet;
import twisk.outils.TailleComposants;


/**
 * Vue de l'activité
 * Représentant graphique des activités du mondeIG
 */
public class VueActiviteIG extends VueEtapeIG implements Observateur {
    private MondeIG mon;
    private Label name;

    /**
     *  Constructeur de la VueActiviteIG
     * @param monde mondeIG
     * @param etape activité à représenter
     */
    public VueActiviteIG(MondeIG monde, EtapeIG etape){
        super(monde, etape);
        TailleComposants tc = TailleComposants.getInstance();
        this.mon = monde;
        this.name= new Label(etape.getNomEtape()+" "+etape.getIdentifiant());
        this.name.setPadding(new Insets(0, 14, 10, 14));
        double x = etape.getPosX();
        double y = etape.getPosY();
        HBox visu = new HBox();
        visu.setPrefSize(tc.getInstance().getLargeurVisu(),tc.getInstance().getLongueurVisu());
        this.setPadding(new Insets(3, 3, 3, 3));
        this.setStyle("-fx-border-color: #0059FF; -fx-background-color: #ffffff;-fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 5; -fx-border-radius: 5;");
        visu.setStyle("-fx-border-color: #0059FF;-fx-background-color: #c3ffe3;-fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-padding: 2px,2px,2px,2px");
        this.relocate(x,y);
        visu.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(name,visu);
        this.setPrefSize(tc.getInstance().getLargeurEtape(),tc.getInstance().getLongueurEtape());
    }


    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {

    }
}

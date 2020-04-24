package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;
import twisk.ecouteurs.EcouteurAdd;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.Sujet;
import twisk.outils.TailleComposants;

/**
 * Classe VueOutils
 * Représentant graphique des outils de l'application
 */
public class VueOutils extends TilePane implements Observateur {
    private Button ajouter;
    private Button simuler;
    private MondeIG mon;

    /**
     * Constructeur de la VueOtils
     * @param monde monde à intégrer
     */
    public VueOutils(MondeIG monde){
        super();
        TailleComposants tc = TailleComposants.getInstance();
        this.mon=monde;
        this.ajouter= new Button("+");
        this.simuler= new Button("Simuler");
        Tooltip add = new Tooltip("Ajouter une activité");
        Tooltip sim = new Tooltip("Procéder à une simulation");
        this.ajouter.setMinSize(tc.getLargeurBouton(),tc.getLongueurBouton());
        this.simuler.setMinSize(tc.getLargeurSimuler(),tc.getLongueurSimuler());
        this.ajouter.setTooltip(add);
        this.simuler.setTooltip(sim);
        this.ajouter.setStyle("-fx-border-color: #ff214b; -fx-background-color: #fff1bb; -fx-font-weight: bold; -fx-text-fill: blue; -fx-font-size: 2em; -fx-background-radius: 5; -fx-border-radius: 5;");
        this.simuler.setStyle("-fx-border-color: #ff214b; -fx-background-color: #fff1bb; -fx-font-weight: bold; -fx-text-fill: blue; -fx-background-radius: 5; -fx-border-radius: 5;");
        this.ajouter.setOnAction(new EcouteurAdd(mon));
        this.getChildren().addAll(ajouter,simuler);
        this.setStyle("-fx-background-color: #d3ffae");
        this.mon.ajouterObservateur(this);
    }


    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {

    }
}

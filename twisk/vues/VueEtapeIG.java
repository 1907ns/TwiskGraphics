package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import twisk.ecouteurs.EcouteurSlcEtape;
import twisk.ecouteurs.EctrDragDetected;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.Sujet;
import twisk.outils.TailleComposants;

/**
 * Classe VueEtapeIG
 * Représentant graphique des étapes du monde
 */
public abstract class VueEtapeIG extends VBox implements Observateur {
    private Label name;
    private MondeIG mon;
    private EtapeIG etp;
    private String id;

    /**
     * Constructeur VueEtapeIG
     * @param monde mondeIG
     * @param etape etape à représenter
     */
    public VueEtapeIG(MondeIG monde, EtapeIG etape){
        super();
        TailleComposants tc = TailleComposants.getInstance();
        this.mon = monde;
        this.etp = etape;
        this.id=etp.getIdentifiant();
        this.getChildren().addAll();
        this.setMinSize(tc.getInstance().getLargeurEtape(),tc.getInstance().getLongueurEtape());
        this.name= new Label();
        this.setId(etp.getIdentifiant());
        this.iconeES();
        this.setOnMouseClicked(new EcouteurSlcEtape(mon,this));
        this.setOnDragDetected(new EctrDragDetected(mon,this));
    }

    /**
     * Getter de l'étape à représenter
     * @return l'étape à représenter
     */
    public EtapeIG getEtape() {
        return etp;
    }

    /**
     * Getter du label de la vue ---> label=nom+id de l'étape
     * @return label de la vue
     */
    public Label getName() {
        return name;
    }

    /**
     * Permet de placer une icone si l'étape est une entrée ou une sortie ou bien les 2 à la fois
     */
    public void iconeES(){
        Label icone= new Label();
        if(this.etp.getEntree() && !this.etp.getSortie()){
            icone.setText("E");
            icone.setTextFill(Color.RED);
            icone.setAlignment(Pos.CENTER);
            this.getChildren().add(icone);
        }else if(this.etp.getSortie() && !this.etp.getEntree()){
            icone.setText("S");
            icone.setTextFill(Color.RED);
            icone.setAlignment(Pos.CENTER);
            this.getChildren().add(icone);
        }else if(this.etp.getEntree() && this.etp.getSortie()){
            icone.setText("ES");
            icone.setTextFill(Color.RED);
            icone.setAlignment(Pos.CENTER);
            this.getChildren().add(icone);
        }
    }

    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {

    }
}

package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import twisk.ecouteurs.*;
import twisk.mondeIG.MondeIG;


/**
 * Classe VueMenu
 * Représentant graphique du menu de l'application
 */
public class VueMenu extends MenuBar implements Observateur {

    private MondeIG mon;
    private VueMondeIG vueMondeIG;

    /**
     * Constructeur de la vue du Menu
     * @param mondeIG monde représenté
     * @param vm vue du monde représenté
     */
    public VueMenu(MondeIG mondeIG, VueMondeIG vm){
        super();
        this.mon=mondeIG;
        this.vueMondeIG=vm;
        VBox vBox= new VBox(this);
        // LES MENUS
        Menu fichier = new Menu("Fichier");
        Menu edition = new Menu("Edition");
        Menu monde = new Menu("Monde");
        Menu param = new Menu("Paramètres");
        Menu style = new Menu("Style");
        // LES ITEMS
        MenuItem quitter = new MenuItem("Quitter");
        MenuItem supprimer= new MenuItem("Supprimer la sélection");
        MenuItem renommer = new MenuItem("Renommer la sélection");
        MenuItem effacer = new MenuItem("Effacer la sélection");
        MenuItem entree = new MenuItem("Entrée");
        MenuItem sortie=new MenuItem("Sortie");
        MenuItem ecart= new MenuItem("Ecart-Temps");
        MenuItem temps= new MenuItem("Temps");
        MenuItem dark = new MenuItem("Dark");
        MenuItem light = new MenuItem("Light");

        //LES ECOUTEURS
        quitter.setOnAction(new EcouteurQuitter(this.mon));
        supprimer.setOnAction(new EcouteurSupprimer(mon));
        renommer.setOnAction(new EcouteurRenommer(mon));
        effacer.setOnAction(new EffacerSelection(mon));
        entree.setOnAction(new EcouteurEntree(mon));
        sortie.setOnAction(new EcouteurSortie(mon));
        temps.setOnAction(new EcouteurTemps(mon));
        ecart.setOnAction(new EcouteurEcTps(mon));
        dark.setOnAction(new EcouteurDark(mon,vueMondeIG));
        light.setOnAction(new EcouteurLight(mon,vueMondeIG));

        // AJOUT DES ITEMS
        fichier.getItems().addAll(quitter);
        edition.getItems().addAll(supprimer,renommer,effacer);
        monde.getItems().addAll(entree,sortie);
        param.getItems().addAll(temps,ecart);
        style.getItems().addAll(dark,light);
        this.getMenus().addAll(fichier,edition,monde,param,style);
        this.mon.ajouterObservateur(this);
    }

    /**
     *  Fonction de mise à jour de la vue/l'observateur
     */
    @Override
    public void reagir() {

    }
}

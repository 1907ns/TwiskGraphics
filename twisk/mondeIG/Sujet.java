package twisk.mondeIG;

import twisk.vues.Observateur;
import twisk.vues.Vue;

import java.util.ArrayList;

/**
 * Classe sujet
 */
public class Sujet {

    private ArrayList<Observateur> listeObservateur = new ArrayList<Observateur>();

    /**
     * Fonction ajoutant un observateur au sujet
     * @param o Observateur à ajouter
     */
    public void ajouterObservateur(Observateur o){
        this.listeObservateur.add(o);
    }

    /**
     * Fonction notifiant les observateurs du sujet
     */
    public void notifierObservateurs() {
        this.listeObservateur.forEach(o->o.reagir());
    }

    /**
     * Fonction toString du sujet
     */
    @Override
    public String toString() {
        return "Sujet{" +
                "listeObservateur=" + listeObservateur +
                '}';
    }
}

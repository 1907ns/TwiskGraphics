package twisk.mondeIG;

import javafx.scene.media.MediaException;
import javafx.scene.shape.Arc;
import twisk.exceptions.ExceptionArcUn;
import twisk.exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;
import twisk.vues.Vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MondeIG extends Sujet  implements Iterable<EtapeIG>{
    private HashMap <String,EtapeIG> hashEtape; // collection d'étapes
    private ArrayList<ArcIG> listeArcs; //collection d'arcs
    private ArrayList <EtapeIG> listEtapeSlct; // collection des étapes sélectionnées
    private PointDeControleIG ptDepart; //point de départ de l'arc
    private ArrayList<EtapeIG> listeEntrees; // collection des entrées du monde
    private ArrayList<EtapeIG> listeSorties; // collection des sorties du monde


    /**
     * Constructeur du monde
     */
    public MondeIG(){
        hashEtape = new HashMap<String, EtapeIG>(10);
        this.listeArcs = new ArrayList<ArcIG>();
        this.listEtapeSlct=new ArrayList<EtapeIG>();
        this.listeEntrees = new ArrayList<>();
        this.listeSorties = new ArrayList<>();
    }

    /**
     * Ajout d'une étape dans le monde via la hashmap
     * @param type clé de l'étape
     */
    public void ajouter(String type){
        FabriqueIdentifiant fab = FabriqueIdentifiant.getInstance();
        EtapeIG step = new ActiviteIG(type,fab.getInstance().getIdentifiantEtape(),10, 10);
        this.hashEtape.put(step.getIdentifiant(),step); //ajout de l'étape avec son identifiant comme clé
        this.notifierObservateurs();

    }


    /**
     * Procédure permettant d'ajouter un arc au monde
     * @param pt1 point de départ
     * @param pt2 point d'arrivée
     */
    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {
        if(pt1.getEtape().equals(pt2.getEtape())){
            throw new ExceptionArcUn("Impossible d'ajouter un arc à la même étape");
        }else if(pt1.getId().equals(pt2.getId())){
            throw new ExceptionArcUn("Les points ont le même ID même s'ils appatiennent à des étapes différentes");
        }else{
            this.listeArcs.add(new ArcIG(pt1,pt2));
        }

    }

    public void supprimerArc(ArcIG a){
        this.listeArcs.remove(a);
    }

    /**
     * Iterateur qui itère sur les étapes du monde
     * @return un itérateur qui itère sur les étapes du monde
     */
    @Override
    public Iterator<EtapeIG> iterator() {
        return hashEtape.values().iterator();
    }


    /**
     * Itérateur qui itère sur les arcs du monde
     * @return un itérateur qui itère sur les arcs du monde
     */
    public Iterator<ArcIG> iterateurArc(){
        return listeArcs.iterator();
    }



    /**
     * Getter de la hashmap d'étapes
     * @return la hashmap d'étape
     */
    public HashMap<String, EtapeIG> getHashEtape() {
        return hashEtape;
    }


    /**
     * @return le nombre d'étapes du monde
     */
    public int nbEtape(){
        return this.hashEtape.size();
    }


    /**
     * @return le point de départ d'un arc
     */
    public PointDeControleIG getPtDepart() {
        return ptDepart;
    }


    /**
     * Remet le point de départ à null
     */
    public void setPtDepart() {
        this.ptDepart = null;
    }


    /**
     * Permet de sélectionner un point à proprement dit
     * ou bien d'ajouter un arc si deux points sont sélectionnés
     * @param p Point à affecter ou à mettre en relation avec le point de départ
     */
    public void ptSelectionne(PointDeControleIG p) throws TwiskException {
        if(this.ptDepart == null){
            this.ptDepart = p; //si le point de départ n'est pas sélectionné, on le sélectionne
        }else{
            ajouter(ptDepart,p);// sinon on relie les deux points sélectionnés par un arc
            this.notifierObservateurs();
            this.ptDepart=null;
        }
    }


    /**
     * Permet la mémorisation des étapes sélectionnées par le monde
     * @param etape étape sélectionnée, à mémoriser par le monde
     */
    public void ajouterEtapeSlct(EtapeIG etape){
        etape.setEstSelect(true);
        this.listEtapeSlct.add(etape);
    }


    /**
     * Permet l'oubli de l'étape déselectionnée
     * @param etape étape désélectionnée
     */
    public void retirerEtapeDeselect(EtapeIG etape){
        etape.setEstSelect(false);
        this.listEtapeSlct.remove(etape);
    }


    /**
     * Permet de vider l'arraylist des étapes sélectionnées
     */
    public void removeAllEtapeDeSelect(){
        for(int i =0; i<this.listEtapeSlct.size();i++){
            this.listEtapeSlct.get(i).setEstSelect(false);
        }
        this.listEtapeSlct.clear();
    }

    /**
     * Getter de la liste des étape sélectionnées
     * @return la liste des étapes sélectionnées
     */
    public ArrayList<EtapeIG> getListEtapeSlct() {
        return listEtapeSlct;
    }

    /**
     * Fonction qui crée la collection des entrées du monde
     */
    public void aCommeEntree(){
        for(EtapeIG e : this){
            if (e.getEntree()){
                this.listeEntrees.add(e);
            }
        }
    }


    /**
     * Fonction qui crée la collection des sorties du monde
     */
    public void aCommeSortie(){
        for(EtapeIG e : this){
            if (e.getEntree()){
                this.listeSorties.add(e);
            }
        }
    }


    /**
     * Getter liste d'entrées du monde
     */
    public ArrayList<EtapeIG> getListeEntrees() {
        return listeEntrees;
    }


    /**
     * Getter liste sortie du monde
     */
    public ArrayList<EtapeIG> getListeSorties() {
        return listeSorties;
    }

    /**
     * Fonction toString du mondeIG
     */
    @Override
    public String toString() {
        return "MondeIG{" +
                "hashEtape=" + hashEtape +
                '}';
    }
}


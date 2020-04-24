package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


/**
 * Classe de l'étape
 */
public abstract class EtapeIG implements Iterable<PointDeControleIG>{
    private String nom;
    private String identifiant;
    private int posX;
    private int posY;
    private int largeur;
    private int hauteur;
    private ArrayList<PointDeControleIG> listePoint;
    private boolean estSelect;
    private PointDeControleIG p1,p2,p3,p4;
    private boolean entree,sortie;

    /**
     * Constructeur de l'étape
     * @param nom nom de l'étape
     * @param idf identifiant de l'étape
     * @param larg largeur de l'étape
     * @param haut hauteur de l'étape
     */
    public EtapeIG(String nom, String idf, int larg, int haut){
        TailleComposants tc = TailleComposants.getInstance();
        this.nom=nom;
        this.identifiant  =idf;
        this.largeur=tc.getLargeurEtape();
        this.hauteur=tc.getLongueurEtape();
        this.posX = (int)(Math.random() * (800 - 40 + 1) + 40);
        this.posY = (int)(Math.random() * (400 - 40 + 1) + 40);
        this.listePoint=new ArrayList<PointDeControleIG>();
        this.estSelect=false;
        this.entree=false;
        this.sortie=false;
        /***** AJOUT DES POINTS ****/
        p1 = new PointDeControleIG("0",this);
        p2 = new PointDeControleIG("1",this);
        p3 = new PointDeControleIG("2",this);
        p4 = new PointDeControleIG("3",this);
        p1.setPosX(this.getPosX());
        p1.setPosY(this.getPosY()+this.getHauteur()/2);
        p2.setPosX(this.getPosX()+this.getLargeur()/2);
        p2.setPosY(this.getPosY());
        p3.setPosX(this.getPosX()+this.getLargeur()/2+1);
        p3.setPosY(this.getPosY()+this.getHauteur());
        p4.setPosX(this.getPosX()+this.getLargeur());
        p4.setPosY(this.getPosY()+this.getHauteur()/2);
        this.ajouterPointsDeControle(p1,p2,p3,p4);
    }

    /**
     * Getter du nom d'étape
     * @return le nom de l'étape
     */
    public String getNomEtape() {
        return nom;
    }

    /**
     * Getter de la position en Y de l'étape
     * @return la position en Y de l'étape
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Getter de la position en X de l'étape
     * @return la position en X de l'étape
     */
    public int getPosX() {
        return posX;
    }

    @Override
    public String toString() {
        return "nom de l'étape: " + nom + "numéro id"+ identifiant;
    }

    /**
     * Getter de l'identifiant de l'étape
     * @return l'identifiant de l'étape
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Itérateur de point de contrôle de l'étape
     * @return l'itérateur de point de contrôle de l'étape
     */
    @Override
    public Iterator<PointDeControleIG> iterator() {
        ArrayList<PointDeControleIG> pListe = new ArrayList<>();
        for(PointDeControleIG p: listePoint){
            pListe.add(p);
        }
        return pListe.iterator();
    }

    /**
     * Getteur de la collection de points de l'étape
     * @return la collection de points de l'étape
     */
    public ArrayList<PointDeControleIG> getListePoint() {
        return listePoint;
    }

    /**
     * Permet d'ajouter les points de contrôle de l'étape
     * @param tabPoints points de contrôle à ajouter
     */
    public void ajouterPointsDeControle(PointDeControleIG... tabPoints){
        int taille = tabPoints.length;
        for(int i = 0;i<taille;i++){
            this.listePoint.add(tabPoints[i]);
        }
    }

    /**
     * Permet de supprimer tous les points de contrôle de l'étape
     */
    public void retirerPointsDeControle() {
        this.listePoint.clear();
    }

    /**
     * Getter de la hauteur de l'étape
     * @return la hauteur de l'étape
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Getter de la largeur de l'étape
     * @return la largeur de l'étape
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Getter de l'indicateur de sélection de l'étape
     * @return l'indicateur de sélection de l'étape
     */
    public Boolean getEstSelect() {
        return estSelect;
    }

    /**
     * Setter de l'indicateur de sélection de l'étape
     */
    public void setEstSelect(boolean estSelect) {
        this.estSelect = estSelect;
    }

    /**
     * Setter du nom de l'étape
     * @param nom nom que l'on veut obtenir
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Fonction équals de la vlasse EtapeIG
     * @param o étape à comparer
     * @return true si les deux objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtapeIG)) return false;
        EtapeIG that = (EtapeIG) o;
        return Objects.equals(identifiant, that.identifiant);
    }

    /**
     * Setter de la position de l'étape en Y
     * @param posY nouvelle position en Y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Setter de la position de l'étape en X
     * @param posX nouvelle position en X
     */
    public void setPosX(int posX){
        this.posX=posX;
    }

    /**
     * Fonction permettant de positionner les points de contrôle
     * Fonction nécessaire dans le cadre du drag'n drop
     */
    public void setPointPos(){
        p1.setPosX(this.getPosX());
        p1.setPosY(this.getPosY()+this.getHauteur()/2);
        p2.setPosX(this.getPosX()+this.getLargeur()/2);
        p2.setPosY(this.getPosY());
        p3.setPosX(this.getPosX()+this.getLargeur()/2+1);
        p3.setPosY(this.getPosY()+this.getHauteur());
        p4.setPosX(this.getPosX()+this.getLargeur());
        p4.setPosY(this.getPosY()+this.getHauteur()/2);
    }

    /**
     * Getter du booléen définissant l'étape comme une entrée
     * @return  booléen définissant l'étape comme une entrée (true=oui/false=non)
     */
    public boolean getEntree() {
        return entree;
    }

    /**
     * Setter du booléen définissant l'étape comme une entrée
     * @param se valeur que l'on veut affecter à notre booléen
     */
    public void setEntree(boolean se){
        this.entree= se;
    }

    /**
     * Getter du booléen définissant l'étape comme une sortie
     * @return  booléen définissant l'étape comme une sortie (true=oui/false=non)
     */
    public boolean getSortie() {
        return sortie;
    }

    /**
     * Setter du booléen définissant l'étape comme une sortie
     * @param ss valeur que l'on veut affecter à notre booléen
     */
    public void setSortie(boolean ss){
        this.sortie= ss;
    }


}

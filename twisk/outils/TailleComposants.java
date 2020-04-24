package twisk.outils;

/**
 * Singleton pour la taille des composants
 */
public class TailleComposants {

    /** Longueur et largeur du bouton ajouter */
    private int largeurBouton = 45;
    private int longueurBouton = 45;


    /** Longueur et largeur du bouton simuler */
    private int largeurSimuler = 70;
    private int longueurSimuler = 30;

    /** Longueur et largeur d'une vueEtape */
    private int largeurEtape = 100;
    private int longueurEtape = 85;

    /** Longueur et largeur du composant permettant de visualiser les clients */
    private int largeurVisu = 40;
    private int longueurVisu = 40;

    /**
     * Instance de la taille des composants
     */
    private static TailleComposants instance = new TailleComposants();

    /**
     * Constructeur vide
     */
    private TailleComposants(){}

    /**
     * @return l'instance de la taille des composants
     */
    public static TailleComposants getInstance(){
        return instance;
    }

    /**
     * Getter longueur bouton
     * @return longueur bouton
     */
    public int getLongueurBouton() {
        return longueurBouton;
    }

    /**
     * Getter largeur bouton
     * @return largeur bouton
     */
   public int getLargeurBouton(){
        return largeurBouton;
   }

    /**
     * Getter largeur étape
     * @return largeur étape
     */
    public int getLargeurEtape() {
        return largeurEtape;
    }

    /**
     * Getter longueur étape
     * @return longueur étape
     */
    public int getLongueurEtape() {
        return longueurEtape;
    }

    /**
     * Getter largeur Visu
     * @return largeur Visu
     */
    public int getLargeurVisu(){
        return this.largeurVisu;
    }

    /**
     * Getter longueur visu
     * @return longueur visu
     */
    public int getLongueurVisu(){
        return this.longueurVisu;
    }

    public int getLargeurSimuler() {
        return largeurSimuler;
    }

    public int getLongueurSimuler() {
        return longueurSimuler;
    }


}


package twisk.mondeIG;

/**
 * Classe PointDeControleIG
 */
public class PointDeControleIG {
    private String id;
    private EtapeIG etape;
    private int posX;
    private int posY;
    private boolean estSelect;

    /**
     * Constructeur d'un point de contrôle
     * @param id identifiant du point de contrôle
     * @param etape étape à laquelle le point de contrôle est rattaché
     */
    public PointDeControleIG(String id, EtapeIG etape){
        this.id = id;
        this.etape=etape;
        this.posX=etape.getPosX()-20;
        this.posY=etape.getPosY()+20;
        this.estSelect=false;
    }

    /**
     * Getter de l'id du point de contrôle
     * @return l'id du point de contrôle
     */
    public String getId() {
        return id;
    }

    /**
     * Getter de la position en X du point de contrôle
     * @return la position en X du point de contrôle
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Getter de la position en Y du point de contrôle
     * @return la position en Y du point de contrôle
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Setter de la position en X du point de contrôle
     * @param posX nouvelle position en X
     */
    public void setPosX(int posX){
        this.posX=posX;
    }

    /**
     * Setter de la position en Y du point de contrôle
     * @param posY nouvelle position en Y
     */
    public void setPosY(int posY){
        this.posY=posY;
    }

    /**
     * Getter de l'étape à laquelle le point est rattaché
     * @return l'étape à laquelle le point est rattaché
     */
    public EtapeIG getEtape() {
        return etape;
    }

    /**
     * Fonction to String du point de contrôle
     * @return une chaîne de caractère relative au point de contrôle
     */
    public String toString(){
        return "L'id de cet étape est: " + id;
    }

    /**
     * Getter du booléen déterminant si le point de contrôle est sélectionné
     * @return le booléen déterminant si le point de contrôle est sélectionné
     */
    public boolean getEstSelect() {
        return estSelect;
    }

    /**
     * Setter du booléen déterminant si le point de contrôle est sélectionné
     * @param sel booléen à affecter
     */
    public void setEstSelect(boolean sel){
        this.estSelect=sel;
    }
}

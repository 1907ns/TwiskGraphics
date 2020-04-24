package twisk.mondeIG;

/**
 * Classe ArcIG
 * permettant de créer les arcs entre les étapes
 */
public class ArcIG {
    private PointDeControleIG pt1; //point de départ
    private PointDeControleIG pt2; // point d'arrivée
    private boolean estSelect;

    /**
     * Constructeur de l'arc
     * @param pt1 point de départ de l'arc
     * @param pt2 point d'arrivée de l'arc
     */
    public ArcIG(PointDeControleIG pt1, PointDeControleIG pt2){
        this.pt1=pt1;
        this.pt2=pt2;
        this.estSelect=false;
    }

    /**
     * Getter du point de départ de l'arc
     * @return le point de départ de l'arc
     */
    public PointDeControleIG getPt1() {
        return pt1;
    }

    /**
     * Getter du point d'arrivée de l'arc
     * @return le point d'arrivée de l'arc
     */
    public PointDeControleIG getPt2() {
        return pt2;
    }

    /**
     * Getter du booléen qui permet de savoir si l'arc est sélectionné ou pas
     * @return booléen qui permet de savoir si l'arc est sélectionné ou pas (true=oui/false=non)
     */
    public boolean getEstSelect() {
        return estSelect;
    }

    /**
     * Setter du booléen qui permet de savoir si l'arc est sélectionné ou pas
     * @param estSelect valeur que l'on veut affecter à notre attribut booléen
     */
    public void setEstSelect(boolean estSelect) {
        this.estSelect = estSelect;
    }

    /**
     * @return une chaîne de caractère relative à l'arcIG
     */
    @Override
    public String toString() {
        return "Les deux points de contrôle sont p1: "+pt1.getId()+" p2: "+pt2.getId();
    }
}

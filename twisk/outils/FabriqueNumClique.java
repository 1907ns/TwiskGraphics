package twisk.outils;

/**

 *  AYATA Enes

 * un singleton générant le nombre de clique total sur les points de contrôle d'un monde

 */

public class FabriqueNumClique{

    /**
     * @field noClique = le numéro du clique
     *
     */

    private int noClique = 0;


    /**
     * Création de l'instance
     */
    private static FabriqueNumClique instance  = new FabriqueNumClique();

    /**
     * constructeur vide
     */

    private FabriqueNumClique(){}

    /**
     * @return l'instance de FabriqueNumClique
     */
    public static FabriqueNumClique getInstance(){
        return instance;
    }

    /**
     * @return le numéro du clique
     */
    public int getNumClique(){
        return this.noClique++;
    }

    /**
     * Setter du numéro de clique
     * @param noClique numéro à affecter
     */
    public void setNoClique(int noClique) {
        this.noClique = noClique;
    }


    /**
     * @return une chaine de caractère d'un nombre, qui s'incrémente après son utilisation
     */
    public String getIdentifiantClqie(){
        return Integer.toString(noClique++ );
    }


}


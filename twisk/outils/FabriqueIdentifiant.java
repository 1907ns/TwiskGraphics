 package twisk.outils;

/**

 *  AYATA Enes

 * un singleton générant un numéro id

 */

public class FabriqueIdentifiant{

    /**

     * @field noEtape le compteur donnant un id aux étapes d'un monde

     */

    private int noEtape = 0;


    /**
     * Création de l'instance
     */
    private static FabriqueIdentifiant instance  = new FabriqueIdentifiant();

    /**
     * constructeur vide
     */

    private FabriqueIdentifiant(){}

    public static FabriqueIdentifiant getInstance(){

        return instance;

    }

    public void setNoEtape(int noEtape) {
        this.noEtape = noEtape;
    }

    /**

     * @return une chaine de caractère d'un nombre, qui s'incrémente après son utilisation

     */


    public String getIdentifiantEtape(){

        return Integer.toString(noEtape++ );
    }


}


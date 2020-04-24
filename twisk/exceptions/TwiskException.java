package twisk.exceptions;

import javafx.scene.control.Alert;

/**
 * Classe héritière de la classe Exception
 * représentant toutes les exceptions déclenchées
 * durant l'utilisation de l'appli
 */
public class TwiskException extends Exception {
    public TwiskException(String errorMsg){
        super(errorMsg);
    }
}

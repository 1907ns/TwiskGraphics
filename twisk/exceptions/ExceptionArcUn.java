package twisk.exceptions;

import javafx.scene.control.Alert;

/**
 * Exception déclenchée si un arc relie
 * 2 points de la même étape ou
 * 2 points ayant le même identifiant
 */
public class ExceptionArcUn extends TwiskException {
    public ExceptionArcUn(String errorMsg) {
        super(errorMsg);
    }
}

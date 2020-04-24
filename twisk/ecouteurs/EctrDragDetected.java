package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import twisk.mondeIG.MondeIG;

import twisk.vues.VueEtapeIG;

/**
 * Ecouteur permettant de savoir
 * si le drag est détecté
 */
public class EctrDragDetected implements EventHandler<MouseEvent> {
    private VueEtapeIG vueEtapeIG;
    private MondeIG mondeIG;

    public EctrDragDetected(MondeIG mon, VueEtapeIG vueEtape){
        this.mondeIG=mon;
        this.vueEtapeIG=vueEtape;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Dragboard db = vueEtapeIG.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(vueEtapeIG.getId());
        db.setContent(content);
        mouseEvent.consume();
    }
}

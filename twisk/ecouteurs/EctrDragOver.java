package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import twisk.mondeIG.MondeIG;
import twisk.vues.Observateur;
import twisk.vues.VueMondeIG;


/**
 * Ecouteur permettant de finaliser le drag'n drop
 */
public class EctrDragOver implements EventHandler<DragEvent>, Observateur {

    private VueMondeIG vueMondeIG;
    private MondeIG mondeIG;

    public EctrDragOver(MondeIG mon, VueMondeIG vm){
        this.mondeIG=mon;
        this.vueMondeIG=vm;
    }
    @Override
    public void handle(DragEvent dragEvent) {
        if(dragEvent.getDragboard().hasString()){
            dragEvent.acceptTransferModes(TransferMode.MOVE);
        }

        dragEvent.consume();

    }

    @Override
    public void reagir() {

    }
}

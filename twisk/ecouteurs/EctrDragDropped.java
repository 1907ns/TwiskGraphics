package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twisk.mondeIG.MondeIG;
import twisk.vues.Observateur;
import twisk.vues.VueEtapeIG;
import twisk.vues.VueMondeIG;

/**
 * Ecouteur permettant de drop le composant graphique
 * que l'on a drag
 */
public class EctrDragDropped implements EventHandler<DragEvent>, Observateur {

    private MondeIG mondeIG;
    private VueMondeIG vueMondeIG;

    public EctrDragDropped(MondeIG mon, VueMondeIG vm){
        this.mondeIG=mon;
        this.vueMondeIG=vm;

    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if(db.hasString()){
            String nodeId = db.getString(); //nodeId est l'identifiant de l'étape
            VueEtapeIG ve = (VueEtapeIG) vueMondeIG.lookup("#"+nodeId);
            if(ve !=null){
                ve.getEtape().setPosX((int)dragEvent.getX());
                ve.getEtape().setPosY((int)dragEvent.getY());
                ve.getEtape().setPointPos();
                ve.relocate((int)dragEvent.getX(),(int)dragEvent.getY());

                /**** COLLISION BAS ECRAN */
                if(dragEvent.getY()>vueMondeIG.getHeight()){
                    ve.getEtape().setPosX((int)dragEvent.getX());
                    ve.getEtape().setPosY((int)vueMondeIG.getHeight()-ve.getEtape().getHauteur());
                    ve.getEtape().setPointPos();
                    ve.relocate((int)dragEvent.getX(),(int)vueMondeIG.getHeight()-ve.getEtape().getHauteur());
                }

                /** COLLISION HAUT ECRAN */
                if(dragEvent.getY()<vueMondeIG.getMaxHeight()){
                    ve.getEtape().setPosX((int)dragEvent.getX());
                    ve.getEtape().setPosY((int)dragEvent.getY()+ve.getEtape().getHauteur());
                    ve.getEtape().setPointPos();
                    ve.relocate((int)dragEvent.getX(),(int)dragEvent.getY()+ve.getEtape().getHauteur());
                }

                /** COLLISION DROITE **/
                if(dragEvent.getX()>vueMondeIG.getMaxWidth()-ve.getEtape().getLargeur()){
                    ve.getEtape().setPosX((int)dragEvent.getX()-ve.getEtape().getLargeur());
                    ve.getEtape().setPosY((int)dragEvent.getY());
                    ve.getEtape().setPointPos();
                    ve.relocate((int)dragEvent.getX()-ve.getEtape().getLargeur(),(int)dragEvent.getY());
                }

                /** COLLISION GAUCHE */
                if(dragEvent.getX()<ve.getEtape().getLargeur()){
                    ve.getEtape().setPosX(0);
                    ve.getEtape().setPosY((int)dragEvent.getY());
                    ve.getEtape().setPointPos();
                    ve.relocate(0,(int)dragEvent.getY());
                }
                success=true;
            }else if(ve==null){
                System.out.println("nul");
            }
        }
        mondeIG.notifierObservateurs();
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

    @Override
    public void reagir() {

    }
}

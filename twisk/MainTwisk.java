package twisk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueActiviteIG;
import twisk.vues.VueMenu;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;



public class MainTwisk extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        MondeIG mon = new MondeIG();
        VueOutils vue = new VueOutils(mon);
        VueMondeIG vueMonde = new VueMondeIG(mon);
        VueMenu vMenu = new VueMenu(mon,vueMonde);
        vue.setAlignment(Pos.BOTTOM_LEFT);
        root.setTop(vMenu);
        root.setBottom(vue);
        root.setCenter(vueMonde);
        primaryStage.setTitle("Twisk");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

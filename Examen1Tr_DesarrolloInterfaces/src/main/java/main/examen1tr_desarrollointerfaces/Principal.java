package main.examen1tr_desarrollointerfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("gestionDietetica-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 900, 480);
        stage.setTitle("Examen Desarrollo Interfaces 2022");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



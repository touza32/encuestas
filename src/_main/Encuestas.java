package _main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Encuestas extends Application{

    public static void main(String[] args) {
        System.out.println("Encuestas");
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/vista/VentanaPrincipal.fxml"));
        Parent root = fxmlLoader.load();
        Scene  scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Encuestas");
        primaryStage.show();
        
    }
    
}

package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this class contains the main method which allows the GUI to run.

 * @author Zuhayr
 *
 */
public class Driver extends Application {
    
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MyView.fxml"));
    Scene scene = new Scene(root, 700, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
  
}

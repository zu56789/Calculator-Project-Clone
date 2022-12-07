package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * this class controls what happens on the javafx GUI.

 * @author Zuhayr
 *
 */
public class MyView {

  @FXML
  private Button calculateButton;

  @FXML
  private Label calculatedLabel;

  @FXML
  private TextField expressionField;

  @FXML
  private Label expressionLabel;

  @FXML
  private RadioButton infixRadioButton;

  @FXML
  private Pane mainPane;

  @FXML
  private TextField resultField;

  @FXML
  private RadioButton rpnRadioButton;
    
  @FXML
  void isPressed(ActionEvent event) {

  }

}

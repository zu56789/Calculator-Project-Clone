package uk.ac.rhul.cs2800;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 * this class controls what happens on the javafx GUI.

 * @author Zuhayr
 *
 */
public class MyView {
  
  private CalcModel model = new CalcModel();
  private boolean infix;
  
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
  private ToggleGroup rpnorinfix;
   
  @FXML
  void isPressed(ActionEvent event)  {
    expressionType();
    try {
      resultField.setText(String.valueOf(model.evaluate(expressionField.getText(), infix)));
    } catch (Exception e) {
      resultField.setText("Invalid Expression");
    } 
  }

  /**
   * this method uses a radioButton ToggleGroup listener 
   * to determine the correct value of the boolean infix value.
   */
  public void expressionType() {
    rpnorinfix.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue,
          Toggle newValue) {
        RadioButton rb = (RadioButton) rpnorinfix.getSelectedToggle();
        
        if (rb != null) {
          String s = rb.getText();
          if (s.equals("Infix")) {
            infix = true;
          } else {
            infix = false;
          }
        }
      }
    });
  }
  
}

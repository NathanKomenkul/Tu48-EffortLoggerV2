//Authorship: Patrick Hall

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class PlanningPokerController {
	
	@FXML
    private TextArea userStoryTextArea;

    @FXML
    private TextField projectNameTextField;

    @FXML
    private TextField keywordsTextField;

    @FXML
    private Button saveNextButton;

    @FXML
    private Button importDataButton;
    
    @FXML
    private void handleSaveNextAction() {
        String userStory = userStoryTextArea.getText();
        String projectName = projectNameTextField.getText();
        String keywords = keywordsTextField.getText();

        // process or store these values as needed
        // ...

        // After processing, you can navigate to the next screen or perform other actions
    }
    
    private void handleImportDataAction() {
        // Logic for importing data
    }
}


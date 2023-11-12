//Authorship: Matthew Moen

package application;
// All required imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;

// The Controller class
public class Controller implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
	private static User user;
// The label for the Project selection	
	@FXML
	private Label myLabel;
	
// The label for the Project status
	@FXML
	private Label statusLabel;
// The buttons for the opening and closing the status
	@FXML
	private Button open;

	@FXML
	private Button close;
	
// The button for going back to the main console
	@FXML
	private Button consoleButton;
	
// The methods for having the status change when open or close are pressed
	public void open(ActionEvent e) {
		statusLabel.setText("Status: Open");
	}
	public void close(ActionEvent e) {
		statusLabel.setText("Status: Closed");
	}
// The Choice Box for the Project selection
	@FXML
	private ChoiceBox<String> myChoiceBox;
	
// The Choice Box for the Defect selection
	@FXML
	private ChoiceBox<String> defectBox;
	
// The Choice Box for the Fix selection
	@FXML
	private ChoiceBox<String> fixBox;
	
// The List Views used for the Steps and Defect Category
	@FXML
	private ListView<String> injectList;
	
	@FXML
	private ListView<String> removeList;
	
	@FXML
	private ListView<String> defectList;
	
// The strings used to test the prototype
	String[] project = {"Project 1", "Project 2", "Project 3"};
	String[] defect = {"Defect 1", "Defect 2", "Defect 3"};
	String[] inject = {"Step 1", "Step 2", "Step 3"};
	String[] remove = {"Step 1", "Step 2", "Step 3"};
	String[] category = {"Category 1", "Category 2", "Category 3"};
	String[] fix = {"Fix 1", "Fix 2", "Fix 3"};
// The manual filling of each UI element	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 myChoiceBox.getItems().addAll(project);
		 defectBox.getItems().addAll(defect);
		 injectList.getItems().addAll(inject);
		 removeList.getItems().addAll(remove);
		 defectList.getItems().addAll(category);
		 fixBox.getItems().addAll(fix);
		}
	
	public void goToConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Submission4Prototype.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	}

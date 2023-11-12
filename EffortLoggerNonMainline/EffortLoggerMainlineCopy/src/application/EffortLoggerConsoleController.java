//Authorship: Maria Marschalik Lucan

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EffortLoggerConsoleController implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Spinner<String> project;
	@FXML
	private Spinner<Integer> lifeCycle;
	@FXML
	private Spinner<String> effortCategory;
	@FXML
	private Spinner<String> subordinate;
	@FXML
	private Text clock;
	@FXML
	private Rectangle rectangleClock;
	
	//Spinner<String> theProject = "Event Project";
	
	
	String x = "test";
	ObservableList<String> projectList = FXCollections.observableArrayList("Buisness Project", "Development Project", "Prototype Project");
	ObservableList<String> effortCategoryList = FXCollections.observableArrayList(" Plans", "Development", "Testing", "Organization");
	
	ObservableList<String> subordinateList = FXCollections.observableArrayList("Project item 1", "Project item 2", "Project item 3");
	
	String currProject;
	int currLifeCycle;
	String currEffortCategory;
	String currSubordinate;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//iterate through project list
		SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(projectList);
		valueFactory.setValue(projectList.get(0));
		//this.project = projectList;
		project.setValueFactory(valueFactory);
		//currProject.equals(project.getValue());
		currProject = project.getValue(); 
		
		//iterate through Effort Category list
		SpinnerValueFactory<String> valueFactoryEffort = new SpinnerValueFactory.ListSpinnerValueFactory<String>(effortCategoryList);
		valueFactoryEffort.setValue(currEffortCategory);
		effortCategory.setValueFactory(valueFactoryEffort);
		currEffortCategory = effortCategory.getValue();
		
		//iterate through Subordinate list
		SpinnerValueFactory<String> valueFactoryEmpty = new SpinnerValueFactory.ListSpinnerValueFactory<String>(subordinateList);
		valueFactoryEmpty.setValue(currSubordinate);
		subordinate.setValueFactory(valueFactoryEmpty);
		currSubordinate = subordinate.getValue();
		
		//iterate through life cycle steps
		SpinnerValueFactory<Integer> valueFact = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		valueFact.setValue(1);
		lifeCycle.setValueFactory(valueFact);
		currLifeCycle = lifeCycle.getValue();
		
	} 
	
	@FXML
	private Button start;
	@FXML
	private Button stop;
	@FXML
	private Button back;
	
	
	//start an activity
	@FXML
	public void startActivity(ActionEvent event) {
		//Change color of rectangle and change text displayed
		rectangleClock.setFill(Color.GREEN);
		clock.setText("Clock is running");
	}
	//stop an activity
	@FXML
	public void stopActivity(ActionEvent event) {
		//Change color of rectangle and change text displayed
		rectangleClock.setFill(Color.RED);
		clock.setText("Clock is stopped");
	}
	
	//call New Task scene
	@FXML
	public void newTask(ActionEvent event) throws IOException {
		System.out.println("new task");
		root = FXMLLoader.load(getClass().getResource("NewTask.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		//System.out.println("new task2");
		
	}
	
	//call Current Task scene
	@FXML
	public void currentTasks(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CurrentTasks.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//call Effort Log Editor scene
	@FXML
	public void effortLogEditor(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("NextScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//call Defect Log Console scene
	@FXML
	public void defectLogConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("defect.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//call Definitions scene
	@FXML
	public void definitions(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("NextScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//call Effort and Defect Logs scene
	@FXML
	public void effortDefectLogs(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("NextScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//call Planning Poker Tool scene
	@FXML
	public void planningPoker(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PlanningPokerSetup.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void console(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Submission4Prototype.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}


	
}
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {
    @FXML
    private ObservableList<Task> taskList;
    @FXML
    private ChoiceBox<String> projectBox;
    @FXML
    private ChoiceBox<String> categoryBox;
    @FXML
    private ChoiceBox<String> priorityLevel;

    @FXML
    private Text projectNameText;
    @FXML
    private Text completionDateText;
    @FXML
    private ChoiceBox priorityBox;
    @FXML
    private Button editButton;

    @FXML
    private Text projectNameText1;
    @FXML
    private Text completionDateText1;
    @FXML
    private ChoiceBox priorityBox1;
    @FXML
    private Button editButton1;

    //checks the source of the edit task command and send the approproate index to the update page
    @FXML
    private void editTask(ActionEvent event) throws IOException {
        if (event.getSource() == editButton) {
            System.out.println("Go to main console");
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("NewTask.fxml"));
            Parent firstView = firstLoader.load();
            NewTaskController targetController = firstLoader.getController();
            targetController.initializeData(taskList);
            targetController.populateTables(taskList.get(0),0);
            Scene scene = new Scene(firstView);
            Stage stage = (Stage) createTaskButton.getScene().getWindow();
            stage.setScene(scene);
        } else {
            System.out.println("Go to main console");
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("NewTask.fxml"));
            Parent firstView = firstLoader.load();
            NewTaskController targetController = firstLoader.getController();
            targetController.initializeData(taskList);
            targetController.populateTables(taskList.get(1),1);
            Scene scene = new Scene(firstView);
            Stage stage = (Stage) createTaskButton.getScene().getWindow();
            stage.setScene(scene);
        }

    }

    @FXML
    private void editTask1(ActionEvent event) {
        System.out.println("Go to main console");
    }
    //initializes values to the scene based on values within list
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Welcome!");

        ObservableList<String> projects = FXCollections.observableArrayList("Project 1", "Project 2", "Project 3");
        projectBox.setItems(projects);
        projectBox.setValue(projects.get(0));

        ObservableList<String> categories = FXCollections.observableArrayList("Security", "User Interface", "Authorization");
        categoryBox.setItems(categories);
        categoryBox.setValue(categories.get(0));




    }
    //initializes values to the scene based on values within list, and sets them as invisible if the list is non existent
    public void initializeData(ObservableList<Task> dataList) {
        taskList = dataList;
        System.out.println(taskList);
        //for (Task tsk: taskList)]{
        if(taskList.size() == 0 ){
            projectNameText.setVisible(false);
            completionDateText.setVisible(false);
            priorityBox.setVisible(false);
            editButton.setVisible(false);
            projectNameText1.setVisible(false);
            completionDateText1.setVisible(false);
            priorityBox1.setVisible(false);
            editButton1.setVisible(false);

        }

        if(taskList.size() > 0 ){
            projectNameText.setText(taskList.get(0).getTaskName());
            completionDateText.setText(String.valueOf(taskList.get(0).getFinishDate()));
            priorityBox.setValue(taskList.get(0).getPriority());

            projectNameText1.setVisible(false);
            completionDateText1.setVisible(false);
            priorityBox1.setVisible(false);
            editButton1.setVisible(false);
        }

        if(taskList.size() > 1 ){
            projectNameText1.setText(taskList.get(1).getTaskName());
            completionDateText1.setText(String.valueOf(taskList.get(1).getFinishDate()));
            priorityBox1.setValue(taskList.get(1).getPriority());

            projectNameText1.setVisible(true);
            completionDateText1.setVisible(true);
            priorityBox1.setVisible(true);
            editButton1.setVisible(true);
        }

        //}

    }
    @FXML
    private Button createTaskButton;
    //transisitons back to the create a new task page
    @FXML
    private void createNewTask(ActionEvent event)  throws Exception {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("NewTask.fxml"));
        Parent firstView = firstLoader.load();

        NewTaskController targetController = firstLoader.getController();
        targetController.initializeData(taskList);

        Scene scene = new Scene(firstView);

        // Get the current stage
        Stage stage = (Stage) createTaskButton.getScene().getWindow();

        // Set the new scene (first view) on the current stage
        stage.setScene(scene);
    }

    @FXML
    private Button consoleButton;
    @FXML
    private void proceedToConsole(ActionEvent event) {
        System.out.println("Go to main console");
    }


}

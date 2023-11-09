package application;

//import java.awt.Button;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

//import org.w3c.dom.Text;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewTaskController implements Initializable {
    //list of tasks created by user
    @FXML
    private ObservableList<Task> taskList = FXCollections.observableArrayList();
    //list of categories created by user
    ObservableList<String> categories;
    //checks if value is being updated or not
    int editedAt = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //list of projects, categories and priorities initialized
        ObservableList<String> projects = FXCollections.observableArrayList("Project 1", "Project 2", "Project 3");
        projectPicker.setItems(projects);
        projectPicker.setValue(projects.get(0));

        categories = FXCollections.observableArrayList("Security", "User Interface", "Authorization");
        categoryPicker.setItems(categories);
        categoryPicker.setValue(categories.get(0));

        ObservableList<String> prio = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        priorityLevel.setItems(prio);
        priorityLevel.setValue(prio.get(0));
    }

    @FXML
    private ChoiceBox<String> projectPicker;
    @FXML
    private ChoiceBox<String> categoryPicker;
    @FXML
    private ChoiceBox<String> priorityLevel;
    @FXML
    private TextField taskCategoryText;
    @FXML
    private Button createButton;


    @FXML
    //updates the category list with the category that the user chooses
    private void createNewCategory(ActionEvent event) {
        String text = taskCategoryText.getText();
        if (!text.isEmpty()) {
            ObservableList<String> existingCategories = categoryPicker.getItems();
            if (!existingCategories.contains(text)) {
                existingCategories.add(text);
                categoryPicker.setItems(existingCategories);
                taskCategoryText.setText("");
                System.out.println("New category added: " + text);
            } else {
                System.out.println("Category already exists: " + text);
            }
        } else {
            System.out.println("Text field is empty. Please enter a category.");
        }
    }
    //takes in the list from the scene transition
    public void initializeData(ObservableList<Task> dataList) {
        taskList = dataList;
        System.out.println(taskList);
    }
    //updates the tables when a task is edited
    public void populateTables(Task tsk, int index) {
        taskNameBox.setText(tsk.getTaskName());
        priorityLevel.setValue(tsk.getPriority());
        descriptionBox.setText(tsk.getDescription());
        finishDatePicker.setValue(tsk.getFinishDate());
        projectPicker.setValue(tsk.getProject());
        if(!categories.contains(tsk.getCategory())){
            categories.add(tsk.getCategory());
        }
        categoryPicker.setValue(tsk.getCategory());
        editedAt = index;
    }
    //createTaskButton
    //createNewTask
    @FXML
    private TextField taskNameBox;

    @FXML
    private TextField descriptionBox;
    @FXML
    private Button createTaskButton;
    @FXML
    private DatePicker finishDatePicker;
    @FXML
    private Text taskCreatedText;

    //adds the newly created task to the main list
    @FXML
    private void createNewTask(ActionEvent event) {
        String selectedProject = projectPicker.getValue();
        String selectedCategory = categoryPicker.getValue();
        String selectedPriority = priorityLevel.getValue();
        String taskName = taskNameBox.getText();
        String description = descriptionBox.getText();
        LocalDate selectedDate = finishDatePicker.getValue();

        //checks for user input
        if (selectedProject == null || selectedCategory == null || selectedPriority == null ||
                taskName.isEmpty() || description.isEmpty() || selectedDate == null) {
            System.out.println("Please fill in all the required fields.");
            taskCreatedText.setText("Please fill in all the required fields.");
        } else {
            //if user input is valid it then checks for validity
            Task newTask = new Task(selectedProject, selectedCategory, selectedPriority, taskName, description, selectedDate);
            if(editedAt != -1){
                taskCreatedText.setText("Task Updated!");
                taskList.set(editedAt, newTask);
            }else{
                taskCreatedText.setText("New Task Created!");
                taskList.add(newTask);
            }

            System.out.println("New Task Created:");
            System.out.println("Project: " + selectedProject);
            System.out.println("Category: " + selectedCategory);
            System.out.println("Priority: " + selectedPriority);
            System.out.println("Task Name: " + taskName);
            System.out.println("Description: " + description);
            System.out.println("Finish Date: " + selectedDate);

        }
    }

    //checkTasksButton
    //checkPending
    @FXML
    private Button checkTasksButton;
    //transitstions scene to next stage of the current tasks area
    @FXML
    private void checkPending(ActionEvent event) throws Exception {

        FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("CurrentTasks.fxml"));
        Parent secondView = secondLoader.load();

        SecondController targetController = secondLoader.getController();
        targetController.initializeData(taskList);

        Scene scene = new Scene(secondView);

        // Get the current stage
        Stage stage = (Stage) backButton.getScene().getWindow();

        // Set the new scene on the current stage
        stage.setScene(scene);
    }

    //backButton
    //proceedToConsole
    @FXML
    private Button backButton;

    @FXML
    private void proceedToConsole(ActionEvent event) {
        System.out.println("Return to console!");
    }
}
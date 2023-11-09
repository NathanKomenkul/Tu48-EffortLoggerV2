package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// --module-path "/Users/benashkenazi/Downloads/javafx-sdk-21.0.1/lib" --add-modules javafx.controls,javafx.fxml
// --module-path /Users/benashkenazi/Downloads/javafx-sdk-21.0.1/lib --add-modules=javafx.controls


public class NewTasksApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //loads initial scene onto stage
        FXMLLoader fxmlLoader = new FXMLLoader(NewTasksApplication.class.getResource("NewTask.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Effort Logger");
        stage.setScene(scene);




        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
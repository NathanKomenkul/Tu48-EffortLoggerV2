//Authorship: Nathan Komenkul

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

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private static User user;
	
	//Elements of LoginScreen
	@FXML
	Label loginLabel;
	@FXML
	TextField loginID;
	@FXML
	PasswordField loginPassword;
	
	//Elements of CreateAccount
	@FXML
	Label accountLabel;
	@FXML
	TextField accountEmail;
	@FXML
	TextField accountUsername;
	@FXML
	PasswordField accountPassword;
	@FXML
	TextField accountRole;
	
	//Elements of TwoFactor
	@FXML
	Label twoFactorLabel;
	@FXML
	TextField twoFactorCode;
	
	//Number used for Two Factor Authentication
	static int secretNum = (int) (Math.random() * 999999999);
	
	//Event of going to the Login Screen
	public void goToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	 
	//Event of going to the Account Creation Screen
	 public void goToAccountCreation(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 //Event of creating an account
	 public void createAccount(ActionEvent event) throws IOException {
		 String email = accountEmail.getText();
		 String username = accountUsername.getText();
		 String password = accountPassword.getText();
		 String role = accountRole.getText();
		 
		 if (email.equals("") || username.equals("") || password.equals("") || role.equals("")) {
			 accountLabel.setText("Invalid Account Creation: No fields should be empty");
			 accountLabel.setTextFill(Color.RED);
		 }
		 else {
			 user = new User(email, username, password, role);
			 accountEmail.clear();
			 accountUsername.clear();
			 accountPassword.clear();
			 accountRole.clear();
			 accountLabel.setText("Account Creation Successful! Go back to login page to sign in.");
			 accountLabel.setTextFill(Color.GREEN);
		 }
	 }
	 
	 //Event of going to the Two Factor Authentication Screen
	 public void goToTwoFactor(ActionEvent event) throws IOException {
		 String id = loginID.getText();
		 String password = loginPassword.getText();
		 
		 if (user == null) {
			 loginLabel.setText("Invalid Username or Password. Please try again.");
			 loginLabel.setTextFill(Color.RED);
		 }
		 else if ((id.equals(user.getUsername()) || id.equals(user.getEmail())) && password.equals(user.getPassword())) {
			 Parent root = FXMLLoader.load(getClass().getResource("TwoFactor.fxml"));
			 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			 scene = new Scene(root);
			 stage.setScene(scene);
			 stage.show();
			 System.out.println("The passcode for this login is: " + secretNum);
		}
		else {
			loginLabel.setText("Invalid Username or Password. Please try again.");
			loginLabel.setTextFill(Color.RED);
		}
	 }
	 
	 //Event of going to the main console
	 public void goToConsole(ActionEvent event) throws IOException{
		 try {
			 int userPasscode = Integer.parseInt(twoFactorCode.getText());
			 
			 if (userPasscode == secretNum) {
				 Parent root = FXMLLoader.load(getClass().getResource("Submission4Prototype.fxml"));
				 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				 scene = new Scene(root);
				 stage.setScene(scene);
				 stage.show();
			 }
			 else {
				 twoFactorLabel.setText("Invalid passcode. Please try again.");
				 twoFactorLabel.setTextFill(Color.RED);
			 }
		 } catch (NumberFormatException nfe) {
			 twoFactorLabel.setText("Invalid passcode. Please try again.");
			 twoFactorLabel.setTextFill(Color.RED);
		 }
	 }
}

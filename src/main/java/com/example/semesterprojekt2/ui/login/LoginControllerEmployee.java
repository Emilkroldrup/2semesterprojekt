package com.example.semesterprojekt2.ui.login;

import com.example.semesterprojekt2.UseCase;
import com.example.semesterprojekt2.dao.CustomerDAO;
import com.example.semesterprojekt2.dao.EmployeeDAO;
import com.example.semesterprojekt2.model.Customer;
import com.example.semesterprojekt2.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginControllerEmployee {

    @FXML
    private Button backbutton;

    @FXML
    private Button LoginEmployee;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField password;

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;



   @FXML
   protected void Login (ActionEvent event) throws IOException, SQLException {
       List<Employee> allemployees = new EmployeeDAO().getallEmployees();
       boolean LoginCorrect = false;
       for(Employee e : allemployees){
           if(mail.getText().equals(e.getEmail()) && password.getText().equals(e.getPassword())){
               LoginCorrect = true;
               break;
           }
       }
       if(LoginCorrect){

           root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/CreateUser/CreateUser.fxml"));
           stage= (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       } else{
           System.out.println("The Email Or Password Is InCorrect, Pls Check If You Have Typed In The Right Phone Number");
       }
   }

    @FXML
    protected void BackToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/StartScreen/OpeningScene.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

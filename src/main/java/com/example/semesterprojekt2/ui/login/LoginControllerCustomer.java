package com.example.semesterprojekt2.ui.login;

import com.example.semesterprojekt2.dao.CustomerDAO;
import com.example.semesterprojekt2.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginControllerCustomer {

    @FXML
    private Button backbutton;

    @FXML
    private Button createaccount;

    @FXML
    private TextField LoginUser;
    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;





    @FXML
    protected void LoginCustomers(ActionEvent event) throws IOException, SQLException {
        List<Customer> allCustomers = new CustomerDAO().getAllCustomers();
        boolean PhoneNumberCorrect = false;
        for(Customer c : allCustomers){
            if(LoginUser.getText().equals(c.getPhoneNumber())){
                PhoneNumberCorrect = true;
                break;
            }
        }
        if(PhoneNumberCorrect){

            root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/CreateUser/CreateUser.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else{
            System.out.println("No Such Phonenumber Exists In Our System, Pls Check If You Have Typed In The Right Phone Number");
        }

    }



    @FXML
    protected void createaccountscene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/CreateUser/CreateUser.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

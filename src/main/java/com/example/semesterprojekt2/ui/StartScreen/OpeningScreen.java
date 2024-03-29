package com.example.semesterprojekt2.ui.StartScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class OpeningScreen {
    @FXML
    private Label welcomeText;

    @FXML
    private Button Treatment;

    @FXML
    private ImageView Logo;

    @FXML
    private Button Customer;

    @FXML
    private Button Employee;

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;




    //if Customer
    @FXML
    protected void SwitchSceneCustomerLogin(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/Login/LoginCustomer.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void Treatment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/Treatment/Treatmentview.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }
    //If employee
    @FXML
    protected void SwitchSceneEmployeeLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/login/LoginEmployee.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }
}
package com.example.semesterprojekt2.ui.CreateUser;

import com.example.semesterprojekt2.UseCase;
import com.example.semesterprojekt2.dao.AppointmentDAO;
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

public class CreateUser {

    @FXML
    private Button backbutton;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField name;

    @FXML
    private TextField email;
    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    protected void CreateUser(ActionEvent event) throws IOException, SQLException {
        Customer customer = new Customer(name.getText(),email.getText(),phonenumber.getText());
        UseCase.AddCustomer(customer);
    }
    @FXML
    protected void backtologin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/Login/LoginCustomer.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}

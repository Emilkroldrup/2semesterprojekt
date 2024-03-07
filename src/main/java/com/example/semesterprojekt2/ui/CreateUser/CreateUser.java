package com.example.semesterprojekt2.ui.CreateUser;

import com.example.semesterprojekt2.UseCase;
import com.example.semesterprojekt2.dao.AppointmentDAO;
import com.example.semesterprojekt2.dao.CustomerDAO;
import com.example.semesterprojekt2.model.Customer;
import com.example.semesterprojekt2.service.NotificationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import jakarta.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
    protected void CreateUser(ActionEvent event) throws IOException, SQLException, MessagingException {
        CustomerDAO newcustomer = new CustomerDAO();
        boolean phonenumberexists = false;
        List<Customer> allCustomers = newcustomer.getAllCustomers();
        for(Customer c : allCustomers){
            if(phonenumber.getText().equals(c.getPhoneNumber())){
                System.out.println("Please change your Phonenumber Because it is already being used!");
                phonenumberexists = true;
                break;
            }
        }
        if(!phonenumberexists){
            Customer customer = new Customer(name.getText(),email.getText(),phonenumber.getText());
            newcustomer.addCustomer(customer);
            NotificationService.userCreatedNotification(email.getText());
        }

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
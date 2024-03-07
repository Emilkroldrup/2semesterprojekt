package com.example.semesterprojekt2.ui.treatment;

import com.example.semesterprojekt2.dao.TreatmentDAO;
import com.example.semesterprojekt2.model.Treatment;
import com.example.semesterprojekt2.ui.login.LoginControllerCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class TreatmentController {

    @FXML
    Label treatmentsLabel = new Label (); // title
    @FXML
    Label haircutsLabel = new Label();
    @FXML
    Label coloringLabel = new Label();
    @FXML
    Label washingLabel = new Label();
    @FXML
    Label shavingLabel = new Label();

    @FXML
    Button bookingButton = new Button(); // goes to appointment booking
    @FXML
    Button returnButton = new Button(); // returns to former scene

    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    int t = LoginControllerCustomer.id;



    public void backToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/StartScreen/OpeningScene.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println(t);
    }

    public void TologinScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/Login/LoginCustomer.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

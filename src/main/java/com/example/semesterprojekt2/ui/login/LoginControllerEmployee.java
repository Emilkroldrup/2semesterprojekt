package com.example.semesterprojekt2.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginControllerEmployee {

    @FXML
    private Button backbutton;
    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    protected void BackToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/semesterprojekt2/StartScreen/OpeningScene.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
package com.example.semesterprojekt2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView Logo;



    @FXML
    protected void onHelloButtonClick1() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onHelloButtonClick2() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
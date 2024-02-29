package com.example.semesterprojekt2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class GUIMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIMain.class.getResource("StartScreen/OpeningScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 389, 682);
        stage.setTitle("MonkasBarberShop");
        InputStream iconStream = getClass().getResourceAsStream("/Pictures/Frisør-removebg-preview.png");
        Image image = new Image(iconStream);
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
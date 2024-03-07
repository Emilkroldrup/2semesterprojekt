package com.example.semesterprojekt2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GUIMain extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader  loader= new FXMLLoader();
        URL xmlurl = getClass().getResource("StartScreen/OpeningScene.fxml");
        loader.setLocation(xmlurl);
        Parent root = loader.load();

        primarystage.setTitle("HairMonika");
        InputStream iconStream = getClass().getResourceAsStream("/Pictures/Barber-Icon.png");
        Image image = new Image(iconStream);
        primarystage.getIcons().add(image);
        Scene scene = new Scene(root, 389, 682);
        primarystage.setScene(scene);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
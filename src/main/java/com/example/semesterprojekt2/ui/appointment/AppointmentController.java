package com.example.semesterprojekt2.ui.appointment;

import com.example.semesterprojekt2.model.Appointment;
import com.example.semesterprojekt2.dao.AppointmentDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppointmentController {

    @FXML
    private Label titleLabel = new Label();

    @FXML
    private DatePicker datePicker = new DatePicker();

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;


    @FXML
    protected void chooseDate (ActionEvent event) throws IOException{

        datePicker.getOnAction(); // gets clicked date
    }

    public void useDate () {

    }



}

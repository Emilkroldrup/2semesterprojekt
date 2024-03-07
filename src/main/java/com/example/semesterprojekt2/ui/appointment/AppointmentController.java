package com.example.semesterprojekt2.ui.appointment;
import com.example.semesterprojekt2.dao.AppointmentDAO;
import com.example.semesterprojekt2.dao.EmployeeDAO;
import com.example.semesterprojekt2.model.Appointment;
import com.example.semesterprojekt2.model.Customer;
import com.example.semesterprojekt2.model.Employee;
import com.example.semesterprojekt2.service.AppointmentService;
import com.example.semesterprojekt2.ui.login.LoginControllerCustomer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class AppointmentController {

    @FXML
    private Label titleLabel = new Label();

    @FXML
    private DatePicker datePicker = new DatePicker();

    @FXML
    private ComboBox<String> timeComboBox = new ComboBox<>();

    @FXML
    private ComboBox<String> nameComboBox = new ComboBox<>();

    @FXML
    private Button bookingButton = new Button();

    private AppointmentService appointmentService;

    public static int customerId = LoginControllerCustomer.id;

    private EmployeeDAO eDao;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
    
    public void initialize() {
        appointmentService = new AppointmentService();
        
        timeComboBox.getItems().addAll(
                "09:00", "10:00", "11:00",
                "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
        );
        
        EventHandler<ActionEvent> selectionHandler = event -> {
            LocalDate date = datePicker.getValue();
            String time = timeComboBox.getValue();
            
            if (event.getSource() == timeComboBox) {
                System.out.println("Selected time: " + time);
                if (date != null && time != null) {
                    createDateTime(date, time);
                }
            } else if (event.getSource() == datePicker) {
                System.out.println("Selected date: " + date);
                if (time != null) {
                    createDateTime(date, time);
                }
            } 
        };
        
        timeComboBox.setOnAction(selectionHandler);
        datePicker.setOnAction(selectionHandler);
    }

    public void initializeNames () {
        nameComboBox.getItems().addAll(
            "Karina", "Stinna", "Louise"
            );

            String name = nameComboBox.getValue();
            EventHandler<ActionEvent> nameHandler = event -> {

            if (event.getSource() == nameComboBox) {
                System.out.println("Selected employee: " + name);
            }
    };
        nameComboBox.setOnAction(nameHandler);
    }
    
    public void createDateTime(LocalDate date, String time) {
        if (date == null || time == null) {
            System.out.println("Date or time are not selected.");
            return;
        }
    
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.parse(time));
        System.out.println("Selected date and time: " + dateTime);
        LocalDateTime endDateTime = dateTime.plusMinutes(30); // Assuming appointments last for 30 minutes
        
        Appointment a = new Appointment(customerId, 1, dateTime, endDateTime, "Description", false);
        appointmentService.createAppointment(a);
        
        
        
    }
    /* 
    public void bookComplete (Appointment appointment) {
        
        
    }
    */



}

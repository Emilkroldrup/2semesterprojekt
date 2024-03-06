package com.example.semesterprojekt2.ui.appointment;
import com.example.semesterprojekt2.dao.AppointmentDAO;
import com.example.semesterprojekt2.model.Appointment;
import com.example.semesterprojekt2.service.AppointmentService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

    private AppointmentService appointmentService;

    private Appointment appointment1;

    private AppointmentDAO appointmentDAO;

    public void initialize() {
        appointmentService = new AppointmentService(); // Initialize your AppointmentService


        timeComboBox.getItems().addAll( // displays opening hours
                "09:00", "10:00", "11:00",
                "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
        );

        // Event handler for both time and date selection
        EventHandler<ActionEvent> selectionHandler = event -> {
            if (event.getSource() == timeComboBox) {
                LocalDate date = datePicker.getValue(); // Retrieve selected date
                String time = timeComboBox.getValue();
                System.out.println("Selected time: " + time);
                if (date != null && time != null) {
                    createDateTime(date, time); // Call createDateTime with date and time
                }
            } else if (event.getSource() == datePicker) {
                LocalDate date = datePicker.getValue();
                System.out.println("Selected date: " + date);
                createDateTime(date, timeComboBox.getValue());
            }

        };

        // Assign the event handler to both timeComboBox and datePicker
        timeComboBox.setOnAction(selectionHandler);
        datePicker.setOnAction(selectionHandler);

    }

    private void createDateTime(LocalDate date, String time) {
        if (date != null && time != null) {
            LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.parse(time));
            System.out.println("Selected date and time: " + dateTime);
            LocalDateTime endDateTime = dateTime.plusMinutes(30); // Assuming appointments last for 30 minutes
            List<Appointment> appointments = appointmentService.getAppointmentsInRange(dateTime, endDateTime);
            // Handle appointments as needed
            for (Appointment appointment : appointments) {
                // Do something with each appointment
                System.out.println("Appointment: " + appointment);
            }

        } else {
            System.out.println("Date or time is not selected.");
        }
    }

    private void bookAppointment () {

    }

    


}

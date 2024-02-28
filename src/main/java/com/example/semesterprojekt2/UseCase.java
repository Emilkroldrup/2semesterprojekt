package com.example.semesterprojekt2;

import com.example.semesterprojekt2.dao.AppointmentDAO;
import com.example.semesterprojekt2.dao.CustomerDAO;
import com.example.semesterprojekt2.dao.EmployeeDAO;
import com.example.semesterprojekt2.dao.TreatmentDAO;
import com.example.semesterprojekt2.model.Appointment;
import com.example.semesterprojekt2.model.Customer;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class UseCase {

    public static void main (String [] args) throws SQLException {

        AppointmentDAO appointment = new AppointmentDAO();
        CustomerDAO customer = new CustomerDAO();
        EmployeeDAO employee = new EmployeeDAO();
        TreatmentDAO treatment = new TreatmentDAO();

        //Employee employee1 = new Employee("Karina", "karina@gmail.com", "Karina123");
        //employee.addEmployee(employee1);  CHECKED
        //employee.getEmployeeByEmail("karina@gmail.com");  CHECKED

        //Customer customer2 = new Customer("Hanne", "hannekunde@gmail.com", "10222370");
        //customer.addCustomer(customer2);
        //customer.getCustomerById(1); CHECKED
        //customer.getAllCustomers(); CHECKED
        //customer.deleteCustomer(7);
        //customer.getAllCustomers(); CHECKED

        /* Appointment apm = new Appointment(1, 1,
                LocalDateTime.parse("2024-03-15T14:30:00"),LocalDateTime.parse("2024-03-15T15:00:00"), "Trim", false);

         */

        //appointment.addAppointment(apm); CHECKED
        //appointment.denyAppointment(1); CHECKED
    }
}

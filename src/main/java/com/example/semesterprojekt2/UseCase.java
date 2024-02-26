package com.example.semesterprojekt2;

import com.example.semesterprojekt2.dao.AppointmentDAO;
import com.example.semesterprojekt2.dao.CustomerDAO;
import com.example.semesterprojekt2.dao.EmployeeDAO;
import com.example.semesterprojekt2.dao.TreatmentDAO;

public class UseCase {

    public static void main (String [] args) {

        AppointmentDAO appointment = new AppointmentDAO();
        CustomerDAO customer = new CustomerDAO();
        EmployeeDAO employee = new EmployeeDAO();
        TreatmentDAO treatment = new TreatmentDAO();

        //Employee employee1 = new Employee("Karina", "karina@gmail.com", "Karina123");
        //employee.addEmployee(employee1);  CHECKED
        //employee.getEmployeeByEmail("karina@gmail.com");  CHECKED

        //Customer customer1 = new Customer("Berit", "beritkunde@gmail.com", "27131074");
        //customer.addCustomer(customer1); CHECKED
        //customer.getCustomerById(1); CHECKED
        //customer.getAllCustomers(); CHECKED
        //customer.deleteCustomer(1); CHECKED
        //customer.getAllCustomers(); CHECKED
    }
}

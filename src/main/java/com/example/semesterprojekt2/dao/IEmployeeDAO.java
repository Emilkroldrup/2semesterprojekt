package com.example.semesterprojekt2.dao;

import com.example.semesterprojekt2.model.Employee;
import java.sql.SQLException;

public interface IEmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    Employee getEmployeeByEmail(String email) throws SQLException;
}

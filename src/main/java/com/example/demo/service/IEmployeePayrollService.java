package com.example.demo.service;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;

import java.util.List;

//Created IEmployeePayrollService interface to achieve abstraction
public interface IEmployeePayrollService {

//    public String getWelcome();

    public Employee postDataToRepo(EmployeeDTO employeeDTO);

    public List<Employee> getAllData();

    public Employee getDataById(Integer id);

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO);

    public String deleteDataById(Integer id);
}
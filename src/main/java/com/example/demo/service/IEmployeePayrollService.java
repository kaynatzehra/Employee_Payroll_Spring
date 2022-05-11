package com.example.demo.service;
import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.model.EmployeePayrollData;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    String getMessage(String name);

    String postMessage(EmployeePayrollDTO employee);

    String putMessage(String name);

    String getWelcome();

    public EmployeePayrollData postDataToRepo(EmployeePayrollDTO employee);

    public List<EmployeePayrollData> getAllData();

    public Optional<EmployeePayrollData> getDataById(Integer id);

    public EmployeePayrollData updateDataById(Integer id, EmployeePayrollDTO employeeDTO);

    public String deleteDataById(Integer id);
}
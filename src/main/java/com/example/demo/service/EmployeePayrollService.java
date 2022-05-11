package com.example.demo.service;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.model.EmployeePayrollData;
import com.example.demo.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository repository;

    public String getMessage(String name) {
        return "Welcome To Employee Program " + name;
    }

    public String postMessage(EmployeePayrollDTO employee) {
        return "Hello Employee " + employee.getFirstName() + "" + employee.getLastName() + "!";
    }

    public String putMessage(String name) {
        return "Hey Dude , " + name;
    }

    public String getWelcome() {
        return "Welcome to Employee Payroll App.....!";
    }

    @Override
    public EmployeePayrollData postDataToRepo(EmployeePayrollDTO employeepayrolldata) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(employeepayrolldata);
        repository.save(newEmployee);
        return newEmployee;
    }

    @Override
    public List<EmployeePayrollData> getAllData() {
        List<EmployeePayrollData> list = repository.findAll();
        return list;
    }

    @Override
    public Optional<EmployeePayrollData> getDataById(Integer id) {
        Optional<EmployeePayrollData> newEmployee = repository.findById(id);
        return newEmployee;
    }

    public EmployeePayrollData updateDataById(Integer id, EmployeePayrollDTO employeepayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(id, employeepayrollDTO);
        repository.save(newEmployee);
        return newEmployee;
    }

    public String deleteDataById(Integer id) {
        repository.deleteById(id);
        return "Employee with ID:" + id + " deleted";
    }

}
package com.example.demo.controller;


import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.EmployeePayrollData;

import com.example.demo.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService service;

    //Ability to display welcome message
    @GetMapping("/employeePayrollService")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<String>(service.getWelcome(), HttpStatus.OK);
    }

    //Ability to save employee details to repository
    @PostMapping("/employeePayrollService/create")
    public ResponseEntity<EmployeePayrollData> saveDataToRepo(@RequestBody EmployeePayrollDTO employeepayrolldata) {
        return new ResponseEntity<EmployeePayrollData>(service.postDataToRepo(employeepayrolldata), HttpStatus.OK);
    }

    //Ability to get all employees' data by findAll() method
    @GetMapping("/employeePayrollService/get")
    public ResponseEntity<List<EmployeePayrollData>> getAllDataFromRepo() {
        return new ResponseEntity<List<EmployeePayrollData>>(service.getAllData(), HttpStatus.OK);
    }

    //Ability to get employee data by id
    @GetMapping("/employeePayrollService/get/{id}")
    public ResponseEntity<EmployeePayrollData> getDataFromRepoById(@PathVariable Integer id) {
        Optional<EmployeePayrollData> employee = service.getDataById(id);
        ResponseDTO dto = new ResponseDTO("Data",employee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to update employee data for particular id
    @PutMapping("/employeePayrollService/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id, @RequestBody EmployeePayrollDTO employeepayrollDTO) {
        EmployeePayrollData employee = service.updateDataById(id, employeepayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating Employee PayrollData Successfuly:", employee);
        return new ResponseEntity(employeepayrollDTO, HttpStatus.OK);
    }

    //Ability to delete employee data for particular id
    @DeleteMapping("/employeePayrollService/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}
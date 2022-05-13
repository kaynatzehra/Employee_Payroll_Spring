package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

//Created EmployeeDTO class and added validations to fields
@Data
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee firstName is Invalid")
    private String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message = "ProfilePic cannot be null")
    private String profilePic;

    @NotEmpty(message = "Department name cannot be null")
    private String department;

    @Min(value = 500, message = "Salary should be more than 500")
    private Long salary;

    @JsonFormat(pattern="dd MMM yyyy")
//    @Pattern(regexp = "dd MMM yyyy", message = "Enter Valid Format")
    @NotNull(message = " StartDate should not be empty")
    @PastOrPresent (message = "StartDate should be past or today's date")
    public LocalDate date;

    private String notes;

    public EmployeeDTO() {
        super();
    }
}
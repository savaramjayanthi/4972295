package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/projection")
    public List<EmployeeProjection> getEmployeeProjections(@RequestParam String departmentName) {
        return employeeService.getEmployeeProjections(departmentName);
    }

    @GetMapping("/employees/dto")
    public List<EmployeeDTO> getEmployeeDTOs(@RequestParam String departmentName) {
        return employeeService.getEmployeeDTOs(departmentName);
    }
}


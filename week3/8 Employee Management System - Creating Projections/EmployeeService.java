package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeProjection> getEmployeeProjections(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    public List<EmployeeDTO> getEmployeeDTOs(String departmentName) {
        return employeeRepository.findEmployeeDTOByDepartmentName(departmentName);
    }
}


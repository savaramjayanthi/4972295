package com.example.demo.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private List<EmployeeDTO> employees;

    // Constructor-based projection
    public DepartmentDTO(Long id, String name, List<EmployeeDTO> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    // Getters and Setters
}

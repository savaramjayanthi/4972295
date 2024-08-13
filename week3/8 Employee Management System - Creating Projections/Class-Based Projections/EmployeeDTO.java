package com.example.demo.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String departmentName;

    // Constructor-based projection
    public EmployeeDTO(Long id, String name, String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
    }

    // Getters and Setters
}


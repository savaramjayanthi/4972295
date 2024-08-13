package com.example.demo.projection;

public interface EmployeeProjection {
    Long getId();
    String getName();
    String getDepartmentName();

    // Use @Value to define derived properties
    @Value("#{target.department.name}")
    String getDepartmentName();
}

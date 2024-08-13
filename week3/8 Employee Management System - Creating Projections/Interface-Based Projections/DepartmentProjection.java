package com.example.demo.projection;

import java.util.List;

public interface DepartmentProjection {
    Long getId();
    String getName();
    List<EmployeeProjection> getEmployees();
}


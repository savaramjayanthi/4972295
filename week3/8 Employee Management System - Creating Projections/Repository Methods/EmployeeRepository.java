package com.example.demo.repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based projection
    List<EmployeeProjection> findByDepartmentName(String departmentName);

    // Class-based projection
    @Query("SELECT new com.example.demo.dto.EmployeeDTO(e.id, e.name, e.department.name) FROM Employee e WHERE e.department.name = ?1")
    List<EmployeeDTO> findEmployeeDTOByDepartmentName(String departmentName);
}


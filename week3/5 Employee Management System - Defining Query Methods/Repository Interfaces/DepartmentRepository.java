package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method
    Optional<Department> findByName(String name);

    // Custom query method using @Query annotation
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    Optional<Department> searchByName(@Param("name") String name);
}

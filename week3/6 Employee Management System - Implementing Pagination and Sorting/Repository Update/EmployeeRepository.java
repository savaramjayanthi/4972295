package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method
    Optional<Employee> findByName(String name);

    // Derived query method with multiple parameters
    List<Employee> findByPositionAndName(String position, String name);

    // Custom query method using @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchByName(@Param("name") String name);

    // Pagination and sorting for employee list
    Page<Employee> findAll(Pageable pageable);

    // Custom query with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    Page<Employee> searchByNameWithPagination(@Param("name") String name, Pageable pageable);
}

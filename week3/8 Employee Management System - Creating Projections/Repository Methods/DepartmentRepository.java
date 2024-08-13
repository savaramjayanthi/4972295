package com.example.demo.repository;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.Department;
import com.example.demo.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Interface-based projection
    List<DepartmentProjection> findByName(String name);

    // Class-based projection
    @Query("SELECT new com.example.demo.dto.DepartmentDTO(d.id, d.name, e) FROM Department d JOIN d.employees e WHERE d.name = ?1")
    List<DepartmentDTO> findDepartmentDTOByName(String name);
}

package com.example.employeemanagement;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class DepartmentRepositoryTests {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName() {
        Department department = new Department();
        department.setName("HR");
        departmentRepository.save(department);

        Optional<Department> found = departmentRepository.findByName("HR");
        assertTrue(found.isPresent());
    }
}


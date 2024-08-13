// Primary Repository Example
package com.example.demo.repository.primary;

import com.example.demo.model.primary.PrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> {
}

// Secondary Repository Example
package com.example.demo.repository.secondary;

import com.example.demo.model.secondary.SecondaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> {
}


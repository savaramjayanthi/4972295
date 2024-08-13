// Primary Entity Example
package com.example.demo.model.primary;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class PrimaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // Other fields
}

// Secondary Entity Example
package com.example.demo.model.secondary;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class SecondaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    // Other fields
}


package com.jobhub.jobhubapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleadores")
public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombreEmp", nullable = false)
    private String nombreEmp;
    @Column(name = "rubro", nullable = false)
    private String rubro;
    @Column(name = "emailEmp", nullable = false)
    private String emailEmp;
}

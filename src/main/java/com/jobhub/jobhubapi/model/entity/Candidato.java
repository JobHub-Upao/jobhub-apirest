package com.jobhub.jobhubapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidatos")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="profesion", nullable = false)
    private String profesion;
    @Column(name="email", nullable = false)
    private String email;
}

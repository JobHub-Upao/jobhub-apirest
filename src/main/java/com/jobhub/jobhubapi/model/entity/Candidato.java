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
    private Long id;
    @Column(name="nombre", nullable = false, unique = true)
    private String nombre;
    @Column(name="profesion", nullable = false)
    private String profesion;
    @Column(name="email", nullable = true)
    private String email;
}

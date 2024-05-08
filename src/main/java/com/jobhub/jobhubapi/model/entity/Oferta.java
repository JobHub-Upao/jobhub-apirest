package com.jobhub.jobhubapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ofertas")
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "postulante_id", nullable = false)
    private Candidato postulante;
    @ManyToOne
    @JoinColumn(name = "ofertante_id", nullable = false)
    private Empleador ofertante;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "segmentoObjetivo", nullable = false)
    private String segmentoObjetivo;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
}

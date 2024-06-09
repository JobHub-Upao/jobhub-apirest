package com.jobhub.jobhubapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaResponseDTO {
    private Long id;
    /*private CandidatoResponseDTO postulante;
    private EmpleadorResponseDTO ofertante;*/
    private String titulo;
    private String descripcion;
    private String segmentoObjetivo;
}

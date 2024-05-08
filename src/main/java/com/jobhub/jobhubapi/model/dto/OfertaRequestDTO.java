package com.jobhub.jobhubapi.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaRequestDTO {
    private Long id;
    @NotNull(message = "El título no puede estar vacio")
    private String titulo;
    @NotNull(message = "El título no puede estar vacio")
    private String descripcion;
    @NotNull(message = "El título no puede estar vacio")
    private String segmentoObjetivo;
    @NotNull(message = "El título no puede estar vacio")
    private String id_postulante;
    @NotNull(message = "El título no puede estar vacio")
    private String id_ofertante;
}

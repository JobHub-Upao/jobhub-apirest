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
    @NotNull(message = "La descripcion no puede estar vacia")
    private String descripcion;
    @NotNull(message = "El el segemento objetivo puede estar vacio")
    private String segmentoObjetivo;

}

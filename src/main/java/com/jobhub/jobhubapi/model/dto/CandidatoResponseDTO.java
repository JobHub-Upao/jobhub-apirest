package com.jobhub.jobhubapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoResponseDTO {
    private Long id;
    private String nombre;
    private String profesion;
    private String email;
}

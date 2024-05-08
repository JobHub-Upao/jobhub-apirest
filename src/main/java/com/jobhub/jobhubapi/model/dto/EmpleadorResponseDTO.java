package com.jobhub.jobhubapi.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadorResponseDTO {
    private Long id;
    private String nombreEmp;
    private String rubro;
    private String emailEmp;
}

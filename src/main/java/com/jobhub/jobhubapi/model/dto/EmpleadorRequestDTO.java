package com.jobhub.jobhubapi.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadorRequestDTO {
    @NotBlank(message = "Nombre de empleador no puede quedar en blanco")
    private String nombreEmp;
    @NotBlank(message = "Rubro de empleador no puede quedar en blanco")
    private String rubro;
    @NotBlank(message = "Email de empleador no puede quedar en blanco")
    @Email
    private String emailEmp;

}

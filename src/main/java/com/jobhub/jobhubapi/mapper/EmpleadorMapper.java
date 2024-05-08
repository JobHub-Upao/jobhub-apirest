package com.jobhub.jobhubapi.mapper;

import com.jobhub.jobhubapi.model.dto.EmpleadorRequestDTO;
import com.jobhub.jobhubapi.model.dto.EmpleadorResponseDTO;
import com.jobhub.jobhubapi.model.entity.Empleador;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EmpleadorMapper {

    private final ModelMapper modelMapper;

    public Empleador convertToEntity(EmpleadorRequestDTO empleadorRequestDTO){
        return modelMapper.map(empleadorRequestDTO, Empleador.class);
    }

    public EmpleadorResponseDTO convertToDTO(Empleador empleador){
        return modelMapper.map(empleador, EmpleadorResponseDTO.class);
    }

    public List<EmpleadorResponseDTO> convertToDTO(List<Empleador> empleadores){
        return empleadores.stream()
                .map(this::convertToDTO)
                .toList();
    }

}

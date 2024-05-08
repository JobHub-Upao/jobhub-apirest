package com.jobhub.jobhubapi.mapper;

import com.jobhub.jobhubapi.model.dto.CandidatoRequestDTO;
import com.jobhub.jobhubapi.model.dto.CandidatoResponseDTO;
import com.jobhub.jobhubapi.model.entity.Candidato;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CandidatoMapper {

    private final ModelMapper modelMapper;

    public Candidato convertToEntity(CandidatoRequestDTO candidatoRequestDTO){
        return modelMapper.map(candidatoRequestDTO, Candidato.class);
    }

    public CandidatoResponseDTO convertToDTO(Candidato candidato){
        return modelMapper.map(candidato, CandidatoResponseDTO.class);
    }

    public List<CandidatoResponseDTO> convertToDTO(List<Candidato> candidatos){
        return candidatos.stream()
                .map(this::convertToDTO)
                .toList();
    }

}

package com.jobhub.jobhubapi.mapper;

import com.jobhub.jobhubapi.model.dto.CandidatoRequestDTO;
import com.jobhub.jobhubapi.model.dto.CandidatoResponseDTO;
import com.jobhub.jobhubapi.model.dto.OfertaRequestDTO;
import com.jobhub.jobhubapi.model.dto.OfertaResponseDTO;
import com.jobhub.jobhubapi.model.entity.Candidato;
import com.jobhub.jobhubapi.model.entity.Oferta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OfertaMapper {

    private final ModelMapper modelMapper;

    public Oferta convertToEntity(OfertaRequestDTO ofertaRequestDTO){
        return modelMapper.map(ofertaRequestDTO, Oferta.class);
    }

    public OfertaResponseDTO convertToDTO(Oferta oferta){
        return modelMapper.map(oferta, OfertaResponseDTO.class);
    }

    public List<OfertaResponseDTO> convertToDTO(List<Oferta> ofertas){
        return ofertas.stream()
                .map(this::convertToDTO)
                .toList();
    }

}

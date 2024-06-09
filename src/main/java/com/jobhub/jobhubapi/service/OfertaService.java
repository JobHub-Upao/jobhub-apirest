package com.jobhub.jobhubapi.service;

import com.jobhub.jobhubapi.exception.ResourceNotFoundException;
import com.jobhub.jobhubapi.mapper.OfertaMapper;
import com.jobhub.jobhubapi.model.dto.OfertaRequestDTO;
import com.jobhub.jobhubapi.model.dto.OfertaResponseDTO;
import com.jobhub.jobhubapi.model.entity.Oferta;
import com.jobhub.jobhubapi.repository.OfertaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OfertaService {

    private final OfertaRepository ofertaRepository;
    private final OfertaMapper ofertaMapper;

    @Transactional(readOnly = true)
    public List<OfertaResponseDTO> getAllOfertas(){
        List<Oferta> ofertas = ofertaRepository.findAll();
        return ofertaMapper.convertToListDTO(ofertas);
    }

    @Transactional(readOnly = true)
    public OfertaResponseDTO getOfertaById(Long id){
        Oferta oferta = ofertaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Oferta no encontrada: "+id));
        return ofertaMapper.convertToDTO(oferta);
    }

    @Transactional
    public OfertaResponseDTO createOferta(OfertaRequestDTO ofertaRequestDTO){
        Oferta oferta = ofertaMapper.convertToEntity((ofertaRequestDTO));
        ofertaRepository.save(oferta);
        return ofertaMapper.convertToDTO(oferta);
    }

    @Transactional
    public OfertaResponseDTO updateOferta(Long id, OfertaRequestDTO ofertaRequestDTO){
        Oferta oferta = ofertaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No se encuentra la Oferta: "+id));
        oferta.setTitulo(ofertaRequestDTO.getTitulo());
        oferta.setDescripcion(ofertaRequestDTO.getDescripcion());
        oferta.setSegmentoObjetivo(ofertaRequestDTO.getSegmentoObjetivo());
        oferta = ofertaRepository.save(oferta);
        return ofertaMapper.convertToDTO(oferta);
    }

    @Transactional
    public void deleteOferta(Long id){
        ofertaRepository.deleteById(id);
    }

}

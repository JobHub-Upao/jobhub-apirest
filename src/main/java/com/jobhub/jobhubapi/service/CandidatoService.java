package com.jobhub.jobhubapi.service;

import com.jobhub.jobhubapi.exception.DuplicateCandidatoException;
import com.jobhub.jobhubapi.exception.ResourceNotFoundException;
import com.jobhub.jobhubapi.mapper.CandidatoMapper;
import com.jobhub.jobhubapi.model.dto.CandidatoRequestDTO;
import com.jobhub.jobhubapi.model.dto.CandidatoResponseDTO;
import com.jobhub.jobhubapi.model.entity.Candidato;
import com.jobhub.jobhubapi.repository.CandidatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;
    private final CandidatoMapper candidatoMapper;

    @Transactional(readOnly = true)
    public List<CandidatoResponseDTO> getAllCandidatos(){
        List<Candidato> candidatos = candidatoRepository.findAll();
        return candidatoMapper.convertToListDTO(candidatos);
    }

    @Transactional(readOnly = true)
    public CandidatoResponseDTO getCandidatoById(Long id){
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Candidato no encontrado: "+id));
        return candidatoMapper.convertToDTO(candidato);
    }

    @Transactional
    public CandidatoResponseDTO createCandidato(CandidatoRequestDTO candidatoRequestDTO){
        Candidato candidato = candidatoMapper.convertToEntity(candidatoRequestDTO);
        boolean existCantidato = candidatoRepository.existsCandidatoByEmail(candidatoRequestDTO.getEmail());

        if(existCantidato){
            throw  new DuplicateCandidatoException("Ya existe un candidato con el correo ingresado");

        }
        //System.out.println("existCantidato:"+existCantidato);
        candidatoRepository.save(candidato);
        return  candidatoMapper.convertToDTO(candidato);
    }

    @Transactional
    public CandidatoResponseDTO updateCandidato(Long id, CandidatoRequestDTO candidatoRequestDTO){
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Candidato no encontrado: "+id));
        candidato.setNombre(candidatoRequestDTO.getNombre());
        candidato.setEmail(candidatoRequestDTO.getEmail());
        candidato.setProfesion(candidatoRequestDTO.getProfesion());
        candidato = candidatoRepository.save(candidato);
        return candidatoMapper.convertToDTO(candidato);
    }

    @Transactional
    public void deleteCandidato(Long id){
        //que pasa si el id que envias no existe
        candidatoRepository.deleteById(id);
    }

}

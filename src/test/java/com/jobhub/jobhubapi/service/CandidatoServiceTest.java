package com.jobhub.jobhubapi.service;

import com.jobhub.jobhubapi.mapper.CandidatoMapper;
import com.jobhub.jobhubapi.model.dto.CandidatoRequestDTO;
import com.jobhub.jobhubapi.model.dto.CandidatoResponseDTO;
import com.jobhub.jobhubapi.model.entity.Candidato;
import com.jobhub.jobhubapi.repository.CandidatoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CandidatoServiceTest {

    @Mock
    private CandidatoRepository candidatoRepository;

    @Mock
    private CandidatoMapper candidatoMapper;

    @InjectMocks
    private CandidatoService candidatoService;


    @Test
    public void testRegistroCandidatoExitoso(){
       //GIVEN = Arrange
        CandidatoRequestDTO candidatoRequestDTO = new CandidatoRequestDTO();

        candidatoRequestDTO.setNombre("Nombre Test");
        candidatoRequestDTO.setProfesion("Profesion Test");
        candidatoRequestDTO.setEmail("Correo Test");

        //simulando el comportamiento de convertir un DTO a una ENTITY
        when(candidatoMapper.convertToEntity(candidatoRequestDTO)).thenReturn(new Candidato());
        // simulando que el correo enviado no le pertenece a ningun candidato
        when(candidatoRepository.existsCandidatoByEmail(candidatoRequestDTO.getEmail())).thenReturn(false);
        //candidatoRepository.save(candidato);
        when(candidatoRepository.save(new Candidato())).thenReturn(new Candidato());
        //candidatoMapper.convertToDTO(candidato);
        when(candidatoMapper.convertToDTO(new Candidato())).thenReturn(new CandidatoResponseDTO());

       //WHEN  = Action
        CandidatoResponseDTO candidatoResponseDTO = new CandidatoResponseDTO();
        candidatoResponseDTO =candidatoService.createCandidato(candidatoRequestDTO);


        candidatoResponseDTO.setId(1L);
        candidatoResponseDTO.setNombre("Nombre Test");
        candidatoResponseDTO.setProfesion("Profesion Test");
        candidatoResponseDTO.setEmail("Correo Test");



       //THEN  = Assert
        assertNotNull(candidatoResponseDTO);
        assertEquals(candidatoRequestDTO.getEmail(),candidatoResponseDTO.getEmail());
    }

}

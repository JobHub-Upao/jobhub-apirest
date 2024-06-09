package com.jobhub.jobhubapi.service;

import com.jobhub.jobhubapi.exception.ResourceNotFoundException;
import com.jobhub.jobhubapi.mapper.EmpleadorMapper;
import com.jobhub.jobhubapi.model.dto.EmpleadorRequestDTO;
import com.jobhub.jobhubapi.model.dto.EmpleadorResponseDTO;
import com.jobhub.jobhubapi.model.entity.Empleador;
import com.jobhub.jobhubapi.repository.EmpleadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadorService {

    private final EmpleadorRepository empleadorRepository;
    private final EmpleadorMapper empleadorMapper;

    @Transactional(readOnly = true)
    public List<EmpleadorResponseDTO> getAllEmpleadores(){
        List<Empleador> empleadores = empleadorRepository.findAll();
        return empleadorMapper.convertToListDTO(empleadores);
    }

    @Transactional(readOnly = true)
    public EmpleadorResponseDTO getEmpleadorById(Long id){
        Empleador empleador = empleadorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Empleador no encontrado: "+id));
        return empleadorMapper.convertToDTO(empleador);
    }

    @Transactional
    public EmpleadorResponseDTO createEmpleador(EmpleadorRequestDTO empleadorRequestDTO){
        Empleador empleador = empleadorMapper.convertToEntity(empleadorRequestDTO);
         empleadorRepository.save(empleador);
         return empleadorMapper.convertToDTO(empleador);
    }

    @Transactional
    public EmpleadorResponseDTO updateEmpleador(Long id, EmpleadorRequestDTO empleadorRequestDTO){
        Empleador empleador = empleadorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Empleador no encontrado: "+id));
        empleador.setNombreEmp(empleadorRequestDTO.getNombreEmp());
        empleador.setRubro(empleadorRequestDTO.getRubro());
        empleador.setEmailEmp(empleadorRequestDTO.getEmailEmp());
        return empleadorMapper.convertToDTO(empleador);
    }

    @Transactional
    public void deleteEmpleador(Long id){
        empleadorRepository.deleteById(id);
    }

}

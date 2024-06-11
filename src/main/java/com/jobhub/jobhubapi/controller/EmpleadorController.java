package com.jobhub.jobhubapi.controller;

import com.jobhub.jobhubapi.model.dto.CandidatoRequestDTO;
import com.jobhub.jobhubapi.model.dto.CandidatoResponseDTO;
import com.jobhub.jobhubapi.model.dto.EmpleadorRequestDTO;
import com.jobhub.jobhubapi.model.dto.EmpleadorResponseDTO;
import com.jobhub.jobhubapi.model.entity.Empleador;
import com.jobhub.jobhubapi.service.EmpleadorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/empleadores")
@AllArgsConstructor
public class EmpleadorController {

    private final EmpleadorService empleadorService;

    @GetMapping
    public ResponseEntity<List<EmpleadorResponseDTO>> getAllEmpleadores(){
        List<EmpleadorResponseDTO> empleadores = empleadorService.getAllEmpleadores();
        return new ResponseEntity<>(empleadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadorResponseDTO> getEmpleadorById(@PathVariable Long id){
        EmpleadorResponseDTO empleador = empleadorService.getEmpleadorById(id);
        return new ResponseEntity<>(empleador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpleadorResponseDTO> createEmpleador(@Validated @RequestBody EmpleadorRequestDTO empleadorDTO){
        EmpleadorResponseDTO createdEmpleador = empleadorService.createEmpleador(empleadorDTO);
        return new ResponseEntity<>(createdEmpleador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadorResponseDTO> updateEmpleador(@PathVariable Long id, @Validated @RequestBody EmpleadorRequestDTO empleadorDTO){
        EmpleadorResponseDTO updateEmpleador = empleadorService.updateEmpleador(id, empleadorDTO);
        return new ResponseEntity<>(updateEmpleador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleador (@PathVariable Long id){
        empleadorService.deleteEmpleador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

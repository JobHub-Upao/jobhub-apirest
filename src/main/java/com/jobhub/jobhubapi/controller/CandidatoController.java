package com.jobhub.jobhubapi.controller;

import com.jobhub.jobhubapi.model.dto.CandidatoRequestDTO;
import com.jobhub.jobhubapi.model.dto.CandidatoResponseDTO;
import com.jobhub.jobhubapi.service.CandidatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/candidatos")
@AllArgsConstructor
public class CandidatoController  {

    private final CandidatoService candidatoService;

    @GetMapping
    public ResponseEntity<List<CandidatoResponseDTO>> getAllCandidatos(){
        List<CandidatoResponseDTO> candidatos = candidatoService.getAllCandidatos();
        return new ResponseEntity<>(candidatos, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/candidatos/4
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoResponseDTO> getCandidatoById(@PathVariable Long id){
        CandidatoResponseDTO candidato = candidatoService.getCandidatoById(id);
        return new ResponseEntity<>(candidato, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CandidatoResponseDTO> createCandidato(@Validated @RequestBody CandidatoRequestDTO candidatoDTO){
        CandidatoResponseDTO createdCandidato = candidatoService.createCandidato(candidatoDTO);
        return new ResponseEntity<>(createdCandidato, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatoResponseDTO> updateCandidato(@PathVariable Long id, @Validated @RequestBody CandidatoRequestDTO candidatoDTO){
        CandidatoResponseDTO updateCandidato = candidatoService.updateCandidato(id, candidatoDTO);
         return new ResponseEntity<>(updateCandidato, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidato (@PathVariable Long id){
        candidatoService.deleteCandidato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

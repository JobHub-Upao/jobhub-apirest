package com.jobhub.jobhubapi.controller;

import com.jobhub.jobhubapi.model.dto.*;
import com.jobhub.jobhubapi.service.CandidatoService;
import com.jobhub.jobhubapi.service.OfertaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
@AllArgsConstructor
public class OfertaController {

    private final OfertaService ofertaService;

    @GetMapping
    public ResponseEntity<List<OfertaResponseDTO>> getAllOfertas(){
        List<OfertaResponseDTO> ofertas = ofertaService.getAllOfertas();
        return new ResponseEntity<>(ofertas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfertaResponseDTO> getOfertaById(@PathVariable Long id){
        OfertaResponseDTO oferta = ofertaService.getOfertaById(id);
        return new ResponseEntity<>(oferta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OfertaResponseDTO> createOferta(@Validated @RequestBody OfertaRequestDTO ofertaDTO){
        OfertaResponseDTO createdOferta = ofertaService.createOferta(ofertaDTO);
        return new ResponseEntity<>(createdOferta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfertaResponseDTO> updateOferta(@PathVariable Long id, @Validated @RequestBody OfertaRequestDTO ofertaDTO){
        OfertaResponseDTO updateOferta = ofertaService.updateOferta(id, ofertaDTO);
        return new ResponseEntity<>(updateOferta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOferta (@PathVariable Long id){
        ofertaService.deleteOferta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

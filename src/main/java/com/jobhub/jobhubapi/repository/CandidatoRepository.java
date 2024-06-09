package com.jobhub.jobhubapi.repository;

import com.jobhub.jobhubapi.model.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    Optional<Candidato> findByNombre (String nombre);

    //SELECT * FROM Candidatos c WHERE c.email=?
    boolean existsCandidatoByEmail(String email);

}

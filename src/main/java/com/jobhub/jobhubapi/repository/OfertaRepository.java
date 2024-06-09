package com.jobhub.jobhubapi.repository;

import com.jobhub.jobhubapi.model.entity.Empleador;
import com.jobhub.jobhubapi.model.entity.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {

    Optional<Oferta> findByTitulo (String titulo);
    /*
    @Query("SELECT t FROM Oferta t WHERE t.titulo=:titulo")
    List<Oferta> findByTitulo (@Param("titulo") String titulo);*/

}

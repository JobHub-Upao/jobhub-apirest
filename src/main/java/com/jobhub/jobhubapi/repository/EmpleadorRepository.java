package com.jobhub.jobhubapi.repository;

import com.jobhub.jobhubapi.model.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadorRepository extends JpaRepository<Empleador, Long> {

    Optional<Empleador> findByNombreEmp (String nombreEmp);

}

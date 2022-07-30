package com.sofka.saintclaire.repository;

import com.sofka.saintclaire.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Optional<Specialty> findSpecialtyBySpecialtyName(String specialtyName);

}

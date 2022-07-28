package com.sofka.saintclaire.repository;

import com.sofka.saintclaire.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {



}

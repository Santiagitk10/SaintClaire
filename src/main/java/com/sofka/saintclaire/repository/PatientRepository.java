package com.sofka.saintclaire.repository;

import com.sofka.saintclaire.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientDNI(Long patientDNI);
}

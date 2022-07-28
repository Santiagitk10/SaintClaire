package com.sofka.saintclaire.service;

import com.sofka.saintclaire.dto.SpecialtyDTO;
import com.sofka.saintclaire.model.Specialty;
import com.sofka.saintclaire.repository.PatientRepository;
import com.sofka.saintclaire.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    private PatientRepository patientRepository;
    private SpecialtyRepository specialtyRepository;

    @Autowired
    public Service(PatientRepository patientRepository, SpecialtyRepository specialtyRepository) {
        this.patientRepository = patientRepository;
        this.specialtyRepository = specialtyRepository;
    }


    public void createNewSpecialty(SpecialtyDTO dto) {
        specialtyRepository.save(convertDtoToEntity(dto));
    }

    public Specialty convertDtoToEntity(SpecialtyDTO dto){
        Specialty specialty = new Specialty();
        specialty.setSpecialtyName(dto.getSpecialtyName());
        specialty.setPhysicianInCharge(dto.getPhysicianInCharge());
        return specialty;
    }

}

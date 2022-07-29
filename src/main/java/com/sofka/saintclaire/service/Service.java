package com.sofka.saintclaire.service;

import com.sofka.saintclaire.dto.PatientInboundDTO;
import com.sofka.saintclaire.dto.SpecialtyInboundDTO;
import com.sofka.saintclaire.model.Patient;
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


    public void createNewSpecialty(SpecialtyInboundDTO dto) {
        specialtyRepository.save(convertSpecialtyInboundDTOtoEntity(dto));
    }

    public void createNewPatient(PatientInboundDTO dto){
        Specialty specialty = specialtyRepository.findById(dto.getFkSpecialtyId()).get();
        Patient patient = convertPatientInboundDTOtoEntity(dto);
        specialty.addPatient(patient);
        patientRepository.save(patient);
        specialtyRepository.save(specialty);
    }





    //DTO Converters
    public Specialty convertSpecialtyInboundDTOtoEntity(SpecialtyInboundDTO dto){
        Specialty specialty = new Specialty();
        specialty.setSpecialtyName(dto.getSpecialtyName());
        specialty.setPhysicianInCharge(dto.getPhysicianInCharge());
        return specialty;
    }

    //TODO Revisar porque por el momento creo que solo me sirve para la creación
    public Patient convertPatientInboundDTOtoEntity(PatientInboundDTO dto){
        Patient patient = new Patient();
        patient.setPatientName(dto.getPatientName());
        patient.setAge(dto.getAge());
        patient.setAppointmentDates("");
        patient.setNumberOfAppointments(0);
        patient.setFkSpecialtyId(dto.getFkSpecialtyId());
        patient.addAppointmentDate();
        return patient;
    }

}

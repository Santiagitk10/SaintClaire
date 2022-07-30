package com.sofka.saintclaire.controller;

import com.sofka.saintclaire.dto.PatientInboundDTO;
import com.sofka.saintclaire.dto.PatientOutboundDTO;
import com.sofka.saintclaire.dto.SpecialtyInboundDTO;
import com.sofka.saintclaire.dto.CompleteOutboundDTO;
import com.sofka.saintclaire.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/saintclaire")
@CrossOrigin("*")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("get/all/specialties")
    public List<CompleteOutboundDTO> getSpecialties(){
        return service.getSpecialties();
    }

    @GetMapping("get/all/patients")
    public List<PatientOutboundDTO> getPatients(){
        return service.getPatients();
    }

    @GetMapping("validate/patient/{patientDNI}")
    public Boolean validatePatient(@PathVariable("patientDNI") Long patientDNI){
        return service.validatePatient(patientDNI);
    }

    @PostMapping("create/specialty")
    public void createNewSpecialty(@RequestBody SpecialtyInboundDTO dto){
        service.createNewSpecialty(dto);
    }

    @PostMapping("create/patient")
    public void createNewPatient(@RequestBody PatientInboundDTO dto){
        service.createNewPatient(dto);
    }


    @PutMapping("update/patient/no/specialty/{patientDNI}")
    public void updateOnlyAppointmentInfo(@PathVariable("patientDNI") Long patientDNI){
        service.updateOnlyAppointmentInfo(patientDNI);
    }

    @PutMapping(path = "update/patient/specialty/{patientDNI}/{specialtyId}")
    public void updateAppointmentInfoWithSpecialty(@PathVariable("patientDNI") Long patientDNI, @PathVariable("specialtyId") Long specialtyId){
        service.updateAppointmentInfoWithSpecialty(patientDNI, specialtyId);
    }

    @DeleteMapping(path = "delete/patient/{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId){
        service.deletePatient(patientId);
    }

}

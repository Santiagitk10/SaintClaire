package com.sofka.saintclaire.controller;

import com.sofka.saintclaire.dto.PatientInboundDTO;
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

    @GetMapping
    public List<CompleteOutboundDTO> getSpecialties(){
        return service.getSpecialties();
    }


    @PostMapping("create/specialty")
    public void createNewSpecialty(@RequestBody SpecialtyInboundDTO dto){
        service.createNewSpecialty(dto);
    }

    @PostMapping("create/patient")
    public void createNewPatient(@RequestBody PatientInboundDTO dto){
        service.createNewPatient(dto);
    }
}

package com.sofka.saintclaire.controller;

import com.sofka.saintclaire.dto.SpecialtyDTO;
import com.sofka.saintclaire.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/saintclaire")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("create/specialty")
    public void createNewSpecialty(@RequestBody SpecialtyDTO dto){
        service.createNewSpecialty(dto);
    }
}

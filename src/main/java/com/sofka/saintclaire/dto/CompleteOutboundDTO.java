package com.sofka.saintclaire.dto;

import com.sofka.saintclaire.model.Patient;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CompleteOutboundDTO {

    private Long specialtyId;
    private String specialtyName;
    private String physicianInCharge;
    private Set<Patient> patientList = new HashSet<>();

}

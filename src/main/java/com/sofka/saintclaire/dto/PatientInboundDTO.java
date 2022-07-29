package com.sofka.saintclaire.dto;

import lombok.Data;

@Data
public class PatientInboundDTO {

    private Long patientDNI;
    private String patientName;
    private int age;
    private Long fkSpecialtyId;

}

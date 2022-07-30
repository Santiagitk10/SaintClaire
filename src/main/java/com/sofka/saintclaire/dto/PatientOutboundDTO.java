package com.sofka.saintclaire.dto;

import lombok.Data;

@Data
public class PatientOutboundDTO {

    private Long patientId;
    private Long patientDNI;
    private String patientName;
    private int age;
    private String appointmentDates;
    private int numberOfAppointments;

}

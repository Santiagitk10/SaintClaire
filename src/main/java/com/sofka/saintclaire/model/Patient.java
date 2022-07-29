package com.sofka.saintclaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "Patient")
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long patientId;
    private Long patientDNI;
    @Column(updatable = false)
    @Size(min = 10, max = 45, message
            = "Patient Name must be between 10 and 45 characters")
    private String patientName;
    @Column(updatable = false)
    @Min(1)
    private int age;
    private String appointmentDates;
    private int numberOfAppointments;
    private Long fkSpecialtyId;

    public void addAppointmentDate(){
        String dates = getAppointmentDates();
        String newDate = LocalDate.now().toString();
        this.appointmentDates = dates += "," + newDate;
        this.numberOfAppointments++;
    }

}

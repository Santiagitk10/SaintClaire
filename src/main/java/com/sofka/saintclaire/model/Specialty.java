package com.sofka.saintclaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Specialty")
@Table(name = "specialty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialty {


    @Id
    @SequenceGenerator(
            name = "specialty_sequence",
            sequenceName = "specialty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "specialty_sequence"
    )
    private Long specialtyId;
    @Size(min = 5, max = 100, message
            = "Specialty Name must be between 5 and 100 characters")
    @Column(unique = true)
    private String specialtyName;
    @Size(min = 10, max = 45, message
            = "Physician Name must be between 10 and 45 characters")
    private String physicianInCharge;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Patient> patientList = new HashSet<>();


    public Specialty(String specialtyName, String physicianInCharge) {
        this.specialtyName = specialtyName;
        this.physicianInCharge = physicianInCharge;
    }
}

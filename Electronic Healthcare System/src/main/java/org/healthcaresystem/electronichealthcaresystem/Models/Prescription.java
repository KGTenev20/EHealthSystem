package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "Prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrescriptionId")
    private Integer prescriptionId;

    @ManyToOne
    @JoinColumn(name = "PersonId", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "MedicineId", nullable = false)
    private Medicine medicine;

    @Column(name = "Repeatable")
    private Boolean repeatable;

    @Column(name = "Frequency", length = 20)
    private String frequency;

    @Column(name = "Dosage", length = 20)
    private String dosage;

    public Prescription() {}

    public Prescription(Person person, Medicine medicine, Boolean repeatable, String frequency, String dosage) {
        this.person = person;
        this.medicine = medicine;
        this.repeatable = repeatable;
        this.frequency = frequency;
        this.dosage = dosage;
    }

    public Prescription(Person currentPerson, Optional<Medicine> medicine, Boolean repeatable, String frequency, String dosage) {
    }

    public Prescription(Integer personId, Medicine medicine, Boolean repeatable, String frequency, String dosage) {
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Boolean getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        this.repeatable = repeatable;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}

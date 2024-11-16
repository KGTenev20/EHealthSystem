package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "MedicalRecord")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicalRecordId")
    private Integer medicalRecordId;

    @ManyToOne
    @JoinColumn(name = "PersonId", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "AllergyId", nullable = false)
    private Allergies allergy;

    @ManyToOne
    @JoinColumn(name = "SicknessId", nullable = false)
    private Sicknesses sickness;

    @ManyToOne
    @JoinColumn(name = "SymptomId", nullable = false)
    private Symptoms symptom;

    public MedicalRecord() {}

    public MedicalRecord(Person person, Allergies allergy, Sicknesses sickness, Symptoms symptom) {
        this.person = person;
        this.allergy = allergy;
        this.sickness = sickness;
        this.symptom = symptom;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Allergies getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergies allergy) {
        this.allergy = allergy;
    }

    public Sicknesses getSickness() {
        return sickness;
    }

    public void setSickness(Sicknesses sickness) {
        this.sickness = sickness;
    }

    public Symptoms getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptoms symptom) {
        this.symptom = symptom;
    }
}

package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Symptoms")
public class Symptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SymptomId")
    private Integer symptomId;

    @Column(name = "Symptom", length = 50, unique = true)
    private String symptom;

    public Symptoms() {}

    public Symptoms(String symptom) {
        this.symptom = symptom;
    }

    public Integer getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}

package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Sicknesses")
public class Sicknesses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SicknessId")
    private Integer sicknessId;

    @Column(name = "Sickness", length = 50, unique = true)
    private String sickness;

    public Sicknesses() {}

    public Sicknesses(String sickness) {
        this.sickness = sickness;
    }

    public Integer getSicknessId() {
        return sicknessId;
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }
}
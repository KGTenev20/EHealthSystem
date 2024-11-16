package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicineId")
    private Integer medicineId;

    @Column(name = "MedicineName", length = 50)
    private String medicineName;

    public Medicine() {}

    public Medicine(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
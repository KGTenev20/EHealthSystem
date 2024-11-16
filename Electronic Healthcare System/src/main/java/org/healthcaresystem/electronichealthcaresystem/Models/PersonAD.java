package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PersonAD")
public class PersonAD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonADId")
    private Integer personADId;

    @ManyToOne
    @JoinColumn(name = "PersonId", nullable = false)
    private Person person;

    @Column(name = "AdmissionDate")
    private Date admissionDate;

    @Column(name = "DischargeDate")
    private Date dischargeDate;

    @Column(name = "Role")
    private String role;

    public PersonAD() {}

    public PersonAD(Person person, Date admissionDate, Date dischargeDate, String role) {
        this.person = person;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.role = role;
    }

    public Integer getPersonADId() {
        return personADId;
    }

    public void setPersonADId(Integer personADId) {
        this.personADId = personADId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
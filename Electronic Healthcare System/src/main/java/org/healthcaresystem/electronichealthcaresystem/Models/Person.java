package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonId")
    private Integer personId;

    @Column(name = "EGN")
    private String EGN;
    @Column(name = "PIK")
    private String PIK;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    public Person() {}

    public Person(Integer personId, String egn, String pik, String firstName, String lastName, String phoneNumber) {
        this.personId = personId;
        this.EGN = egn;
        this.PIK = pik;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String egn) {
        this.EGN = egn;
    }

    public String getPIK() {
        return PIK;
    }

    public void setPIK(String pik) {
        this.PIK = pik;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
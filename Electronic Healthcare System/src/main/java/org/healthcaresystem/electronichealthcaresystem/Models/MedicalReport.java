package org.healthcaresystem.electronichealthcaresystem.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MedicalReport")
public class MedicalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportId")
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "PersonId", nullable = false)
    private Person person;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "Description", length = 500)
    private String description;
    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

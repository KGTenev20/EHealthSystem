package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.*;
import org.healthcaresystem.electronichealthcaresystem.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MedicalRecordRestController {

    private final MedicalRecordService medicalRecordService;
    private final PersonService personService;

    @Autowired
    public MedicalRecordRestController(MedicalRecordService medicalRecordService, PersonService personService) {
        this.medicalRecordService = medicalRecordService;
        this.personService = personService;
    }

    @GetMapping("/api/medicalRecord")
    public List<MedicalRecord> getMedicalRecords() {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            throw new IllegalStateException("No person is currently logged in");
        }
        System.out.println(currentPerson.getPersonId());
        return medicalRecordService.getMedicalRecordsByPersonId(currentPerson.getPersonId());
    }
}

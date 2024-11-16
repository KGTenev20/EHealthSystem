package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.*;
import org.healthcaresystem.electronichealthcaresystem.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MedicalRecordController {

    private final AllergiesService allergiesService;
    private final SymptomsService symptomsService;
    private final SicknessesService sicknessesService;
    private final MedicalRecordService medicalRecordService;

    private final PersonService personService;

    @Autowired
    public MedicalRecordController(AllergiesService allergiesService, SymptomsService symptomsService, SicknessesService sicknessesService, MedicalRecordService medicalRecordService, PersonService personService) {
        this.allergiesService = allergiesService;
        this.symptomsService = symptomsService;
        this.sicknessesService = sicknessesService;
        this.medicalRecordService = medicalRecordService;
        this.personService = personService;
    }

    @GetMapping("/medicalRecord")
    public String showMedicalRecords(Model model) {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            return "redirect:/login";
        }

        List<Allergies> allergies = allergiesService.getAllAllergies();
        List<Symptoms> symptoms = symptomsService.getAllSymptoms();
        List<Sicknesses> sicknesses = sicknessesService.getAllSicknesses();
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsByPersonId(currentPerson.getPersonId());

        model.addAttribute("allergies", allergies);
        model.addAttribute("symptoms", symptoms);
        model.addAttribute("sicknesses", sicknesses);
        model.addAttribute("medicalRecord", medicalRecords);

        return "medicalRecord";
    }

    @PostMapping("/addMedicalRecord")
    public String addMedicalRecord(@RequestParam String allergy, @RequestParam String sickness, @RequestParam String symptom) {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            return "redirect:/login";
        }

        System.out.println(allergy+1);

        medicalRecordService.addMedicalRecord(currentPerson.getPersonId(), allergy, sickness, symptom);
        return "redirect:/medicalRecord";
    }
}

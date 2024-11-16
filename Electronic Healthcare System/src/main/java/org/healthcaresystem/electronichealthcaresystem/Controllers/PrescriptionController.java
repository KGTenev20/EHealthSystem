package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.*;
import org.healthcaresystem.electronichealthcaresystem.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final PersonService personService;
    private final PersonADService personADService;
    private final MedicineService medicineService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService, PersonService personService, PersonADService personADService, MedicineService medicineService) {
        this.prescriptionService = prescriptionService;
        this.personService = personService;
        this.personADService = personADService;
        this.medicineService = medicineService;
    }

    @GetMapping("/prescription")
    public String showPrescriptions(Model model) {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            return "redirect:/login";
        }

        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPersonId(currentPerson.getPersonId());
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("medicines", medicineService.getAllMedicines());

        PersonAD currentPersonAD = personADService.getPersonADById(currentPerson.getPersonId()).orElse(null);
        boolean isDoctor = currentPersonAD != null && "Doctor".equals(currentPersonAD.getRole());
        model.addAttribute("isDoctor", isDoctor);

        return "prescription";
    }

    @PostMapping("/addPrescription")
    public String addPrescription(@RequestParam(required = false) Integer personId,
                                  @RequestParam Integer medicineId,
                                  @RequestParam Boolean repeatable,
                                  @RequestParam String frequency,
                                  @RequestParam String dosage) {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            return "redirect:/login";
        }

        if (personId == null) {
            personId = currentPerson.getPersonId();
        }

        System.out.println(medicineId);
        System.out.println(personId);
        System.out.println(repeatable);
        System.out.println(frequency);
        System.out.println(dosage);

        prescriptionService.addPrescription(personId, medicineId, repeatable, frequency, dosage);
        return "redirect:/prescription";
    }

    @PostMapping("/deletePrescription")
    public String deletePrescription(@RequestParam Integer prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
        return "redirect:/prescription";
    }
}

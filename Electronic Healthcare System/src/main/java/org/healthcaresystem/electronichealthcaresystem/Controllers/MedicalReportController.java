package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.MedicalReport;
import org.healthcaresystem.electronichealthcaresystem.Models.Person;
import org.healthcaresystem.electronichealthcaresystem.Models.PersonAD;
import org.healthcaresystem.electronichealthcaresystem.Services.MedicalReportService;
import org.healthcaresystem.electronichealthcaresystem.Services.PersonADService;
import org.healthcaresystem.electronichealthcaresystem.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/medicalReports")
public class MedicalReportController {

    @Autowired
    private MedicalReportService medicalReportService;

    private final PersonService personService;

    private final PersonADService personADService;

    public MedicalReportController(PersonService personService, PersonADService personADService) {
        this.personService = personService;
        this.personADService = personADService;
    }

    @GetMapping
    public String viewReports(Model model) {
        List<MedicalReport> reports = medicalReportService.getReportsByPerson();
        Person currentPerson = personService.getCurrentPerson();
        PersonAD currentPersonAD = personADService.getPersonADById(currentPerson.getPersonId()).orElse(null);
        String role = currentPersonAD.getRole();
        model.addAttribute("medicalReports", reports);
        model.addAttribute("isDoctor", "doctor".equalsIgnoreCase(role));
        return "medicalReports";
    }

    @PostMapping("/add")
    public String addReport(@RequestParam Integer personId,
                            @RequestParam String title,
                            @RequestParam String description) {
        Person currentPerson = personService.getCurrentPerson();
        if (personId == null) {
            personId = currentPerson.getPersonId();
        }

        System.out.println(personId);
        System.out.println(title);
        System.out.println(description);

        medicalReportService.saveReport(personId, title, description);
        return "redirect:/medicalReports";
    }

    @PostMapping("/delete/{reportId}")
    public String deleteReport(@PathVariable Integer reportId) {
        medicalReportService.deleteReportById(reportId);
        return "redirect:/medicalReports";
    }

    @GetMapping("/download/{title}.txt")
    public ResponseEntity<InputStreamResource> downloadReport(@PathVariable String title) throws IOException {
        MedicalReport report = medicalReportService.findByTitle(title.replace("_", " "));
        if (report == null) {
            return ResponseEntity.notFound().build();
        }

        String reportContent = "Title: " + report.getTitle() + "\nDescription: " + report.getDescription();
        ByteArrayInputStream bis = new ByteArrayInputStream(reportContent.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + title + ".txt");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.TEXT_PLAIN)
                .body(new InputStreamResource(bis));
    }
}
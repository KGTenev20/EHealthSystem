package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.*;
import org.healthcaresystem.electronichealthcaresystem.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalReportService {

    @Autowired
    private MedicalReportRepository medicalReportRepository;

    private final PersonService personService;
    private final PersonADService personADService;
    private final Path fileStorageLocation;

    @Autowired
    public MedicalReportService(MedicalReportRepository medicalReportRepository, PersonService personService, PersonADService personADService) {
        this.medicalReportRepository = medicalReportRepository;
        this.personService = personService;
        this.personADService = personADService;
        this.fileStorageLocation = Paths.get(System.getProperty("user.home"), "Downloads").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }

    public MedicalReport saveReport(Integer personId, String title, String description) {
        Person person = personService.findById(personId);

        MedicalReport medicalReport = new MedicalReport();
        medicalReport.setTitle(title);
        medicalReport.setDescription(description);
        medicalReport.setPerson(person);

        return medicalReportRepository.save(medicalReport);
    }

    public File createReportFile(MedicalReport medicalReport) throws IOException {
        String fileName = medicalReport.getTitle().replaceAll("\\s+", "_") + ".txt";
        Path targetLocation = this.fileStorageLocation.resolve(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetLocation.toFile()))) {
            writer.write("Title: " + medicalReport.getTitle());
            writer.newLine();
            writer.write("Description: " + medicalReport.getDescription());
        }

        return targetLocation.toFile();
    }

    public List<MedicalReport> findAllReports() {
        return medicalReportRepository.findAll();
    }

    public MedicalReport findReportById(Integer id) {
        MedicalReport report = medicalReportRepository.findById(id).orElse(null);;
        return report;
    }

    public void deleteReportById(Integer id) {
        medicalReportRepository.deleteById(id);
    }

    public List<MedicalReport> getReportsByPerson() {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            return List.of();
        }
        PersonAD currentPersonAD = personADService.getPersonADById(currentPerson.getPersonId()).orElse(null);
        String role = currentPersonAD.getRole();
        if ("doctor".equalsIgnoreCase(role)) {
            return medicalReportRepository.findAll();
        } else {
            return medicalReportRepository.findByPerson_PersonId(currentPerson.getPersonId());
        }
    }

    public MedicalReport findByTitle(String title) {
        return medicalReportRepository.findByTitle(title);
    }
}
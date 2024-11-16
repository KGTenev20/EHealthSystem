package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.*;
import org.healthcaresystem.electronichealthcaresystem.Repositories.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Autowired
    public final PersonService personService;

    @Autowired
    public final SicknessesService sicknessesService;
    @Autowired
    public final SymptomsService symptomsService;
    @Autowired
    public final AllergiesService allergiesService;



    @Autowired
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository, PersonService personService, SicknessesService sicknessesService, SymptomsService symptomsService, AllergiesService allergiesService) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.personService = personService;
        this.sicknessesService = sicknessesService;
        this.symptomsService = symptomsService;
        this.allergiesService = allergiesService;
    }
    public List<MedicalRecord> getMedicalRecordsByPersonId(Integer personId) {
        return medicalRecordRepository.findByPerson_PersonId(personId);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public void addMedicalRecord(Integer personId, String allergyName, String sicknessName, String symptomName) {
        Person person = personService.findById(personId);

        Allergies allergy = allergiesService.findById(allergyName);

        Sicknesses sickness = sicknessesService.findById(sicknessName);

        Symptoms symptom = symptomsService.findById(symptomName);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPerson(person);
        medicalRecord.setAllergy(allergy);
        medicalRecord.setSickness(sickness);
        medicalRecord.setSymptom(symptom);

        medicalRecordRepository.save(medicalRecord);
    }
}

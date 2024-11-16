package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.Allergies;
import org.healthcaresystem.electronichealthcaresystem.Models.Symptoms;
import org.healthcaresystem.electronichealthcaresystem.Repositories.SymptomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsService {

    private final SymptomsRepository symptomsRepository;

    @Autowired
    public SymptomsService(SymptomsRepository symptomsRepository) {
        this.symptomsRepository = symptomsRepository;
    }

    public List<Symptoms> getAllSymptoms() {
        return symptomsRepository.findAll();
    }

    public Symptoms getSymptomByName(String symptom) {
        return symptomsRepository.findBySymptom(symptom);
    }

    public Symptoms addSymptom(Symptoms symptom) {
        return symptomsRepository.save(symptom);
    }

    public Symptoms updateSymptom(Integer symptomId, Symptoms symptomDetails) {
        Symptoms symptom = symptomsRepository.findById(symptomId)
                .orElseThrow(() -> new RuntimeException("Symptom not found"));
        symptom.setSymptom(symptomDetails.getSymptom());
        return symptomsRepository.save(symptom);
    }

    public void deleteSymptom(Integer symptomId) {
        symptomsRepository.deleteById(symptomId);
    }

    public Symptoms findByName(String symptomName) {
        return symptomsRepository.findBySymptom(symptomName);
    }

    public Symptoms findById(String symptomName) {
        Integer symptomId = Integer.parseInt(symptomName);
        return symptomsRepository.findById(symptomId).orElse(null);
    }
}

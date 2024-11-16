package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.Allergies;
import org.healthcaresystem.electronichealthcaresystem.Repositories.AllergiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergiesService {

    private final AllergiesRepository allergiesRepository;

    @Autowired
    public AllergiesService(AllergiesRepository allergiesRepository) {
        this.allergiesRepository = allergiesRepository;
    }

    public List<Allergies> getAllAllergies() {
        return allergiesRepository.findAll();
    }

    public Allergies getAllergyByName(String allergy) {
        return allergiesRepository.findByAllergy(allergy);
    }

    public Allergies addAllergy(Allergies allergy) {
        return allergiesRepository.save(allergy);
    }

    public Allergies updateAllergy(Integer allergyId, Allergies allergyDetails) {
        Allergies allergy = allergiesRepository.findById(allergyId)
                .orElseThrow(() -> new RuntimeException("Allergy not found"));
        allergy.setAllergy(allergyDetails.getAllergy());
        return allergiesRepository.save(allergy);
    }

    public void deleteAllergy(Integer allergyId) {
        allergiesRepository.deleteById(allergyId);
    }

    public Allergies findByName(String allergyName) {
        return allergiesRepository.findByAllergy(allergyName);
    }

    public Allergies findById(String allergyName) {
        Integer allergyId = Integer.parseInt(allergyName);
        return allergiesRepository.findById(allergyId).orElse(null);
    }
}

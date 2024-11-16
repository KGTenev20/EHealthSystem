package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.Allergies;
import org.healthcaresystem.electronichealthcaresystem.Models.Sicknesses;
import org.healthcaresystem.electronichealthcaresystem.Repositories.SicknessesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SicknessesService {

    private final SicknessesRepository sicknessesRepository;

    @Autowired
    public SicknessesService(SicknessesRepository sicknessesRepository) {
        this.sicknessesRepository = sicknessesRepository;
    }

    public List<Sicknesses> getAllSicknesses() {
        return sicknessesRepository.findAll();
    }

    public Sicknesses getSicknessByName(String sickness) {
        return sicknessesRepository.findBySickness(sickness);
    }

    public Sicknesses addSickness(Sicknesses sickness) {
        return sicknessesRepository.save(sickness);
    }

    public Sicknesses updateSickness(Integer sicknessId, Sicknesses sicknessDetails) {
        Sicknesses sickness = sicknessesRepository.findById(sicknessId)
                .orElseThrow(() -> new RuntimeException("Sickness not found"));
        sickness.setSickness(sicknessDetails.getSickness());
        return sicknessesRepository.save(sickness);
    }

    public void deleteSickness(Integer sicknessId) {
        sicknessesRepository.deleteById(sicknessId);
    }

    public Sicknesses findByName(String sicknessName) {
        return sicknessesRepository.findBySickness(sicknessName);
    }

    public Sicknesses findById(String sicknessName) {
        Integer sicknessId = Integer.parseInt(sicknessName);
        return sicknessesRepository.findById(sicknessId).orElse(null);
    }
}

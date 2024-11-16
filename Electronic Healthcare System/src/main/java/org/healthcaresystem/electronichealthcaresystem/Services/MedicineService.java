package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.Medicine;
import org.healthcaresystem.electronichealthcaresystem.Repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(Integer medicineId) {
        return medicineRepository.findById(medicineId);
    }

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine updateMedicine(Integer medicineId, Medicine medicineDetails) {
        Medicine medicine = medicineRepository.findById(medicineId).orElseThrow(() -> new RuntimeException("Medicine not found"));
        medicine.setMedicineName(medicineDetails.getMedicineName());
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Integer medicineId) {
        medicineRepository.deleteById(medicineId);
    }
}

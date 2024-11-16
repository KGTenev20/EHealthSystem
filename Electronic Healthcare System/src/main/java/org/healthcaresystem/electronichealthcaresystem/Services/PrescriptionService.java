package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.Medicine;
import org.healthcaresystem.electronichealthcaresystem.Models.Person;
import org.healthcaresystem.electronichealthcaresystem.Models.Prescription;
import org.healthcaresystem.electronichealthcaresystem.Repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PersonService personService;
    private final MedicineService medicineService;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository, PersonService personService, MedicineService medicineService) {
        this.prescriptionRepository = prescriptionRepository;
        this.personService = personService;
        this.medicineService = medicineService;
    }

    public List<Prescription> getPrescriptionsByPersonId(Integer personId) {
        return prescriptionRepository.findByPerson_PersonId(personId);
    }

    public Prescription getPrescriptionById(Integer prescriptionId) {
        return prescriptionRepository.findById(prescriptionId).orElse(null);
    }

    public void addPrescription(Integer personId, Integer medicineId, Boolean repeatable, String frequency, String dosage) {
        Person person = personService.findById(personId);
        Medicine medicine = medicineService.getMedicineById(medicineId).orElse(null);

        Prescription prescription = new Prescription();
        prescription.setDosage(dosage);
        prescription.setFrequency(frequency);
        prescription.setMedicine(medicine);
        prescription.setPerson(person);
        prescription.setRepeatable(repeatable);
        prescriptionRepository.save(prescription);
    }

    public void updatePrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    public void deletePrescription(Integer prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);
    }
}

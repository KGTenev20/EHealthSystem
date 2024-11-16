package org.healthcaresystem.electronichealthcaresystem.Services;

import org.healthcaresystem.electronichealthcaresystem.Models.PersonAD;
import org.healthcaresystem.electronichealthcaresystem.Repositories.PersonADRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonADService {

    private final PersonADRepository personADRepository;

    @Autowired
    public PersonADService(PersonADRepository personADRepository) {
        this.personADRepository = personADRepository;
    }

    public List<PersonAD> getAllPersonADs() {
        return personADRepository.findAll();
    }

    public Optional<PersonAD> getPersonADById(Integer personADId) {
        return personADRepository.findById(personADId);
    }

    public List<PersonAD> getPersonADsByPersonId(Integer personId) {
        return personADRepository.findByPerson_PersonId(personId);
    }

    public PersonAD addPersonAD(PersonAD personAD) {
        return personADRepository.save(personAD);
    }

    public PersonAD updatePersonAD(Integer personADId, PersonAD personADDetails) {
        PersonAD personAD = personADRepository.findById(personADId).orElseThrow(() -> new RuntimeException("PersonAD not found"));
        personAD.setPerson(personADDetails.getPerson());
        personAD.setAdmissionDate(personADDetails.getAdmissionDate());
        personAD.setDischargeDate(personADDetails.getDischargeDate());
        personAD.setRole(personADDetails.getRole());
        return personADRepository.save(personAD);
    }

    public void deletePersonAD(Integer personADId) {
        personADRepository.deleteById(personADId);
    }
}

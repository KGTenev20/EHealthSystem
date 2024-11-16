package org.healthcaresystem.electronichealthcaresystem.Services;

import jakarta.servlet.http.HttpSession;
import org.healthcaresystem.electronichealthcaresystem.Models.Person;
import org.healthcaresystem.electronichealthcaresystem.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private final HttpSession session;

    @Autowired
    public PersonService(PersonRepository personRepository, HttpSession session) {
        this.personRepository = personRepository;
        this.session = session;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Integer personId) {
        return personRepository.findById(personId);
    }

    public Person getPersonByEgn(String EGN) {
        return personRepository.findByEGN(EGN);
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Integer personId, Person personDetails) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setEGN(personDetails.getEGN());
        person.setPIK(personDetails.getPIK());
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setPhoneNumber(personDetails.getPhoneNumber());
        return personRepository.save(person);
    }

    public void deletePerson(Integer personId) {
        personRepository.deleteById(personId);
    }

    public Person getCurrentPerson() {
        Integer personId = (Integer) session.getAttribute("personId");
        System.out.println(personId);
        if (personId == null) {
            return null;
        }
        return personRepository.findById(personId).orElse(null);
    }

    public Person findById(Integer personId) {
        return personRepository.findById(personId).orElse(null);
    }
}
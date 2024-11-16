package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.PersonAD;
import org.healthcaresystem.electronichealthcaresystem.Services.PersonADService;
import org.healthcaresystem.electronichealthcaresystem.Services.PersonService;
import org.healthcaresystem.electronichealthcaresystem.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonADService personADService;
    @GetMapping("/api/person")
    public Person getPerson() {
        return personService.getCurrentPerson();
    }

    @GetMapping("/api/person/ads")
    public List<PersonAD> getCurrentPersonADs() {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            throw new IllegalStateException("No person is currently logged in");
        }
        return personADService.getPersonADsByPersonId(currentPerson.getPersonId());
    }

    @GetMapping("/api/person/{personId}/ads")
    public List<PersonAD> getPersonADsByPersonId(@PathVariable Integer personId) {
        return personADService.getPersonADsByPersonId(personId);
    }
}
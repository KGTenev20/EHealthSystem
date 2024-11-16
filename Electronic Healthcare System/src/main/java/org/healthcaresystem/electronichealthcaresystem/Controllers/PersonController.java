package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.Person;
import org.healthcaresystem.electronichealthcaresystem.Services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String getPersonPage(Model model) {
        Person currentPerson = personService.getCurrentPerson();
        if (currentPerson == null) {
            return "redirect:/login";
        }
        model.addAttribute("person", currentPerson);
        return "person";
    }
}
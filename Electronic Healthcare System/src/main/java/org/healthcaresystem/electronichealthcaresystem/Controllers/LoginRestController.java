package org.healthcaresystem.electronichealthcaresystem.Controllers;

import org.healthcaresystem.electronichealthcaresystem.Models.Person;

import org.healthcaresystem.electronichealthcaresystem.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080") // Adjust according to your frontend origin
public class LoginRestController {

    @Autowired
    private PersonService personService;

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> form, HttpSession session) {
        try {
            String egn = form.get("EGN");
            String pik = form.get("PIK");

            if (egn == null || pik == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EGN and PIK must be provided");
            }

            Person person = personService.getPersonByEgn(egn);
            if (person != null && person.getPIK().equals(pik)) {
                session.setAttribute("personId", person.getPersonId());
                System.out.println("Login successful, personId set in session: " + person.getPersonId());
                return ResponseEntity.ok(person.getPersonId().toString());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid EGN or PIK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred on the server");
        }
    }
}
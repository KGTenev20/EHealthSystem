package org.healthcaresystem.electronichealthcaresystem.Repositories;

import org.healthcaresystem.electronichealthcaresystem.Models.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {
    Symptoms findBySymptom(String symptom);
}
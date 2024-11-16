package org.healthcaresystem.electronichealthcaresystem.Repositories;


import org.healthcaresystem.electronichealthcaresystem.Models.Allergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergiesRepository extends JpaRepository<Allergies, Integer> {
    Allergies findByAllergy(String allergy);
}

package org.healthcaresystem.electronichealthcaresystem.Repositories;

import org.healthcaresystem.electronichealthcaresystem.Models.Sicknesses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SicknessesRepository extends JpaRepository<Sicknesses, Integer> {
    Sicknesses findBySickness(String sickness);
}
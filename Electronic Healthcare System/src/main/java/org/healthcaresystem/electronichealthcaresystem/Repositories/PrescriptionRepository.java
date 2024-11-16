package org.healthcaresystem.electronichealthcaresystem.Repositories;

import org.healthcaresystem.electronichealthcaresystem.Models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    List<Prescription> findByPerson_PersonId(Integer personId);
}

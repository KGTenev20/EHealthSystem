package org.healthcaresystem.electronichealthcaresystem.Repositories;



import org.healthcaresystem.electronichealthcaresystem.Models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    List<MedicalRecord> findByPerson_PersonId(Integer personId);
}
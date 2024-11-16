package org.healthcaresystem.electronichealthcaresystem.Repositories;

import org.healthcaresystem.electronichealthcaresystem.Models.PersonAD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonADRepository extends JpaRepository<PersonAD, Integer> {
    List<PersonAD> findByPerson_PersonId(Integer personId);
}
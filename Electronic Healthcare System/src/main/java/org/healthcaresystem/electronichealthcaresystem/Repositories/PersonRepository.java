package org.healthcaresystem.electronichealthcaresystem.Repositories;

import org.healthcaresystem.electronichealthcaresystem.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEGN(String EGN);
}
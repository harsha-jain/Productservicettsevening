package com.example.productservicettsevening.InheritanceExample.joinedclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);


    Mentor findMentorById(Long id);
}

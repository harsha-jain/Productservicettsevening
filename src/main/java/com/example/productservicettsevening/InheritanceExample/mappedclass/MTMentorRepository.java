package com.example.productservicettsevening.InheritanceExample.mappedclass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MTMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);


    Mentor findMentorById(Long id);
}
package com.example.productservicettsevening.InheritanceExample.mappedclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentor extends User {
    private int numberOfSession;
    private int numberOfMentees;

}

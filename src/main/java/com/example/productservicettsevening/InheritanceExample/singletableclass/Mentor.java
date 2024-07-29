package com.example.productservicettsevening.InheritanceExample.singletableclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private int numberOfSession;
    private int numberOfMentees;

}

package com.example.productservicettsevening.dtos;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Productdto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String Category;

}

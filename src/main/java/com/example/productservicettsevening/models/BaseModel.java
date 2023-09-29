package com.example.productservicettsevening.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private long id;
    private Date isCreated;
    private Date isLastUpdated;
    private boolean isDeleted;
}

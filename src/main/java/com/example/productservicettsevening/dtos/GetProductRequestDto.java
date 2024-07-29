package com.example.productservicettsevening.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductRequestDto {
    private int numberOfResult;
    private int offset;
}

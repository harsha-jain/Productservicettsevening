package com.example.productservicettsevening.Clients.AutheticationClient.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDto {
    private  UserDto userDto;
    private SessionStatus sessionStatus;
}

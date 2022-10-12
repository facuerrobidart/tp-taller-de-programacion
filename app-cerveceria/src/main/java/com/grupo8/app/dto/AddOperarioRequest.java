package com.grupo8.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddOperarioRequest {
    private String username;
    private String nombreCompleto;
    private String password;
}

package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarsRequest {

    @NotBlank
    private String modele;

    @NotBlank
    private String team;

    private Integer piloteId;
}

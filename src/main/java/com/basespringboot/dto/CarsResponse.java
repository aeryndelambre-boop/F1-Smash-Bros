package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarsResponse {

    private Long id;
    private String modele;
    private String team;
    private Integer piloteId;
}

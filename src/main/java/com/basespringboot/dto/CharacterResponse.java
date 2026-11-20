package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor 
public class CharacterResponse {
    
    private String category;
    private String name;
    private String licenceTeam;
    private int age;
    private String description;

}

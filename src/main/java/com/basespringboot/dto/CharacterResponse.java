package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor 
@Getter 
public class CharacterResponse {
    
    private String category;
    private String name;
    private String licence_team;
    private int age;
    private String description;
}

package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CharacterRequest {
    
    @NotBlank 
    private String category;
    
    @NotBlank 
    private String name;
    
    @NotBlank 
    private String licence_team;
    
    @NotBlank 
    private int age;
    
    @NotBlank 
    private String description;
}

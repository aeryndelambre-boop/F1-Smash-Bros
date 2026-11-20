package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;

@Getter 
@Setter
public class CharacterRequest {
    
    @NotBlank 
    private String category;
    
    @NotBlank 
    private String name;
    
    @NotBlank 
    private String licenceTeam;
    
    @NotBlank 
    private int age;
    
    @NotBlank 
    private String description;

}

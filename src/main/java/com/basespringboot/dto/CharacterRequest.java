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

    public String getCategory() {
    return category;
    }

    public String getName() {
        return name;
    }

    public String getLicenceTeam() {
        return licenceTeam;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(String category) {
    this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicenceTeam(String licenceTeam) {
        this.licenceTeam = licenceTeam;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

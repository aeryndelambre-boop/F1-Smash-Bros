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

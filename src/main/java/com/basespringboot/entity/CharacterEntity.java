package com.basespringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor 
@Entity 
@Getter 
@Setter
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String category;
    private String name;
    private String licenceTeam;
    private int age;
    private String description;

    @OneToMany(mappedBy = "pilote")
    private List<CarsEntity> cars = new ArrayList<>();
}
package com.basespringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.basespringboot.repository.CharacterRepository;
import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.dto.CharacterRequest;

@RestController 
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @PostMapping
    public CharacterEntity ajouter(@RequestBody CharacterRequest dto) {
        CharacterEntity character = new CharacterEntity();
        character.setCategory(dto.getCategory());
        character.setName(dto.getName());
        character.setLicenceTeam(dto.getLicenceTeam());
        character.setAge(dto.getAge());
        character.setDescription(dto.getDescription());

        return characterRepository.save(character);
    }
}

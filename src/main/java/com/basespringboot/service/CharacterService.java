package com.basespringboot.service;

import org.springframework.stereotype.Service;
import com.basespringboot.repository.CharacterRepository;
import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.dto.CharacterRequest;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterEntity ajouter(CharacterRequest dto) {
        CharacterEntity character = new CharacterEntity();
        character.setCategory(dto.getCategory());
        character.setName(dto.getName());
        character.setLicenceTeam(dto.getLicenceTeam());
        character.setAge(dto.getAge());
        character.setDescription(dto.getDescription());

        return characterRepository.save(character);
    }
}
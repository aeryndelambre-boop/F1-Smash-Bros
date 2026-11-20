package com.basespringboot.service;

import org.springframework.stereotype.Service;
import com.basespringboot.repository.CharacterRepository;

import lombok.AllArgsConstructor;

import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.dto.CharacterRequest;
import java.util.List;

@Service
@AllArgsConstructor 
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterEntity add(CharacterRequest dto) {
        CharacterEntity character = new CharacterEntity();
        character.setCategory(dto.getCategory());
        character.setName(dto.getName());
        character.setLicenceTeam(dto.getLicenceTeam());
        character.setAge(dto.getAge());
        character.setDescription(dto.getDescription());

        return characterRepository.save(character);
    }

    public List<CharacterEntity> getAllCharacters() {
        return characterRepository.findAll();
    }

    public CharacterEntity update(CharacterRequest dto) {
        CharacterEntity character = characterRepository.findAll().stream()
            .filter(existing -> existing.getName().equals(dto.getName()))
            .findFirst()
            .orElse(null);
        if (character != null) {
            character.setCategory(dto.getCategory());
            character.setLicenceTeam(dto.getLicenceTeam());
            character.setAge(dto.getAge());
            character.setDescription(dto.getDescription());
            return characterRepository.save(character);
        } else {
            throw new RuntimeException("Character not found");
        }
    }

    public void delete(CharacterRequest dto) {
        CharacterEntity character = characterRepository.findAll().stream()
            .filter(existing -> existing.getName().equals(dto.getName()))
            .findFirst()
            .orElse(null);
        if (character != null) {
            characterRepository.delete(character);
        } else {
            throw new RuntimeException("Character not found");
        }
    }
}
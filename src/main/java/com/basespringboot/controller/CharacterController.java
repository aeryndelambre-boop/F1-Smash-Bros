package com.basespringboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.basespringboot.service.CharacterService;
import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.dto.CharacterRequest;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public CharacterEntity add(@RequestBody CharacterRequest dto) {
        return characterService.add(dto);
    }

    @GetMapping
    public List<CharacterEntity> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PutMapping("/{name}")
    public CharacterEntity update(
            @PathVariable String name,
            @RequestBody CharacterRequest dto) {
        return characterService.update(name, dto);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) {
        characterService.delete(name);
    }
}
package com.basespringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.basespringboot.service.CharacterService;
import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.dto.CharacterRequest;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public CharacterEntity ajouter(@RequestBody CharacterRequest dto) {
        return characterService.ajouter(dto);
    }
}
package com.basespringboot.service;

import com.basespringboot.dto.CarsRequest;
import com.basespringboot.dto.CarsResponse;
import com.basespringboot.entity.CarsEntity;
import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.repository.CarsRepository;
import com.basespringboot.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsServiceTest {

    @Test
    void addAssociatesTheCarWithTheRequestedPilot() {
        CarsRepository carsRepository = mock(CarsRepository.class);
        CharacterRepository characterRepository = mock(CharacterRepository.class);
        CarsService service = new CarsService(carsRepository, characterRepository);
        CharacterEntity pilot = new CharacterEntity();
        pilot.setId(7);

        when(characterRepository.findById(7)).thenReturn(Optional.of(pilot));
        when(carsRepository.save(any(CarsEntity.class))).thenAnswer(invocation -> {
            CarsEntity car = invocation.getArgument(0);
            car.setId(12L);
            return car;
        });

        CarsRequest request = new CarsRequest();
        request.setModele("SF-24");
        request.setTeam("Ferrari");
        request.setPiloteId(7);

        CarsResponse response = service.add(request);

        assertEquals(12L, response.getId());
        assertEquals("SF-24", response.getModele());
        assertEquals("Ferrari", response.getTeam());
        assertEquals(7, response.getPiloteId());
    }

    @Test
    void addReturnsNotFoundWhenThePilotDoesNotExist() {
        CarsRepository carsRepository = mock(CarsRepository.class);
        CharacterRepository characterRepository = mock(CharacterRepository.class);
        CarsService service = new CarsService(carsRepository, characterRepository);
        when(characterRepository.findById(404)).thenReturn(Optional.empty());

        CarsRequest request = new CarsRequest();
        request.setModele("SF-24");
        request.setTeam("Ferrari");
        request.setPiloteId(404);

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> service.add(request));

        assertEquals(404, exception.getStatusCode().value());
    }
}

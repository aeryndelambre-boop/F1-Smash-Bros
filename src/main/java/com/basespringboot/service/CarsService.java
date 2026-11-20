package com.basespringboot.service;

import com.basespringboot.dto.CarsRequest;
import com.basespringboot.dto.CarsResponse;
import com.basespringboot.entity.CarsEntity;
import com.basespringboot.entity.CharacterEntity;
import com.basespringboot.repository.CarsRepository;
import com.basespringboot.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CarsService {

    private final CarsRepository carsRepository;
    private final CharacterRepository characterRepository;

    public CarsResponse add(CarsRequest request) {
        CarsEntity car = new CarsEntity();
        updateCar(car, request);
        return toResponse(carsRepository.save(car));
    }

    public List<CarsResponse> getAllCars() {
        return carsRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public CarsResponse getCar(Long id) {
        return toResponse(findCar(id));
    }

    public CarsResponse update(Long id, CarsRequest request) {
        CarsEntity car = findCar(id);
        updateCar(car, request);
        return toResponse(carsRepository.save(car));
    }

    public void delete(Long id) {
        carsRepository.delete(findCar(id));
    }

    private CarsEntity findCar(Long id) {
        return carsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found: " + id));
    }

    private void updateCar(CarsEntity car, CarsRequest request) {
        car.setModele(request.getModele());
        car.setTeam(request.getTeam());
        car.setPilote(findPilote(request.getPiloteId()));
    }

    private CharacterEntity findPilote(Integer piloteId) {
        if (piloteId == null) {
            return null;
        }

        return characterRepository.findById(piloteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Character not found: " + piloteId));
    }

    private CarsResponse toResponse(CarsEntity car) {
        Integer piloteId = car.getPilote() == null ? null : car.getPilote().getId();
        return new CarsResponse(car.getId(), car.getModele(), car.getTeam(), piloteId);
    }
}

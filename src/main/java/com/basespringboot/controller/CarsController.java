package com.basespringboot.controller;

import com.basespringboot.dto.CarsRequest;
import com.basespringboot.dto.CarsResponse;
import com.basespringboot.service.CarsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @PostMapping
    public CarsResponse add(@Valid @RequestBody CarsRequest request) {
        return carsService.add(request);
    }

    @GetMapping
    public List<CarsResponse> getAllCars() {
        return carsService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarsResponse getCar(@PathVariable Long id) {
        return carsService.getCar(id);
    }

    @PutMapping("/{id}")
    public CarsResponse update(
            @PathVariable Long id,
            @Valid @RequestBody CarsRequest request) {
        return carsService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carsService.delete(id);
    }
}

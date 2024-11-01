package com.space.explorer.galaxy_explorer.controllers;

import com.space.explorer.galaxy_explorer.dtos.PlanetRecordDTO;
import com.space.explorer.galaxy_explorer.models.PlanetModel;
import com.space.explorer.galaxy_explorer.repositories.PlanetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;

    @PostMapping("/galaxy")
    public ResponseEntity<PlanetModel> savePlanet(@RequestBody @Valid PlanetRecordDTO planetDTO) {
        var planet = new PlanetModel();
        BeanUtils.copyProperties(planetDTO, planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetRepository.save(planet));
    }

    @GetMapping("/galaxy")
    public ResponseEntity<List<PlanetModel>> getAllPlanets() {
        return ResponseEntity.status(HttpStatus.OK).body(planetRepository.findAll());
    }

    @GetMapping("/galaxy/name/{name}")
    public ResponseEntity<Object> getOnePlanetName(@PathVariable(value = "name") String name) {
        Optional<PlanetModel> planet = planetRepository.findByName(name);
        if (planet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planeta não encontrado nesta galáxia");
        }
        return ResponseEntity.status(HttpStatus.OK).body(planet.get());
    }

    @GetMapping("/galaxy/id/{id}")
    public ResponseEntity<Object> getOnePlanetById(@PathVariable(value = "id") Integer id) {
        Optional<PlanetModel> planet = planetRepository.findById(id);
        if (planet.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planeta não encontrado nesta galáxia");
        return ResponseEntity.status(HttpStatus.OK).body(planet.get());
    }

    @PutMapping("/galaxy/update/{id}")
    public ResponseEntity<Object> updatePlanet(@PathVariable(value = "id") Integer id, @RequestBody @Valid PlanetRecordDTO planetDTO) {
        Optional<PlanetModel> planet = planetRepository.findById(id);
        if (planet.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planeta não encontrado nesta galáxia");
        var planetModel = planet.get();
        BeanUtils.copyProperties(planetDTO, planetModel);
        return ResponseEntity.status(HttpStatus.OK).body(planetRepository.save(planetModel));
    }


    @DeleteMapping("/galaxy/name/{name}")
    public ResponseEntity<Object> deletePlanetByName(@PathVariable(value = "name") String name) {
        Optional<PlanetModel> planet = planetRepository.findByName(name);
        if (planet.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planeta não encontrado nesta galáxia");
        planetRepository.delete(planet.get());
        return ResponseEntity.status(HttpStatus.OK).body("Planeta apagado dos registros do templo");
    }
}

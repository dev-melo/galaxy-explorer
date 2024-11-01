package com.space.explorer.galaxy_explorer.controllers;

import com.space.explorer.galaxy_explorer.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetController {

   @Autowired
    PlanetRepository planetRepository;
}

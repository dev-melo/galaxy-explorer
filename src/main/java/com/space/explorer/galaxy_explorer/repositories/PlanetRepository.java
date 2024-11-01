package com.space.explorer.galaxy_explorer.repositories;

import com.space.explorer.galaxy_explorer.models.PlanetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetModel, UUID> {
}

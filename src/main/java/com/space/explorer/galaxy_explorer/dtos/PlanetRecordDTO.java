package com.space.explorer.galaxy_explorer.dtos;

import jakarta.validation.constraints.NotBlank;

public record PlanetRecordDTO(@NotBlank String name) {
}

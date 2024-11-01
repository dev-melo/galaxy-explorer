package com.space.explorer.galaxy_explorer.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.UUID;

@Entity
@Table(name = "TB_PLANETS")
@Getter
@Setter
public class PlanetModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}

package com.app.poke.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private int level;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    @JsonIgnoreProperties("pokemons")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    @JsonIgnoreProperties("pokemons")
    private Trainer trainer;
}

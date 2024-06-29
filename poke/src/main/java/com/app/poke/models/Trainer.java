package com.app.poke.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("trainer")
    private List<Pokemon> pokemons = new ArrayList<>();
}

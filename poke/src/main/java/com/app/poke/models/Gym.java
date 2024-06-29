package com.app.poke.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("gyms")
    private City city;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("gym")
    private List<Pokemon> pokemons = new ArrayList<>();
}

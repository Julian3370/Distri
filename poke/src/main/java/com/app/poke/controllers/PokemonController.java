package com.app.poke.controllers;

import com.app.poke.models.Pokemon;
import com.app.poke.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id).orElse(null);
    }

    @PostMapping
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.createPokemon(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon, @PathVariable Long id) {
        if (pokemonService.getPokemonById(id).isPresent()) {
            pokemon.setId(id);
            return pokemonService.updatePokemon(pokemon);
        } else {
            // Handle the case where the Pokemon with the given ID does not exist
            return null; // Or throw an exception
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deletePokemon(@PathVariable Long id) {
        if (pokemonService.getPokemonById(id).isPresent()) {
            pokemonService.deletePokemon(id);
            Map<String, String> response = new HashMap<>();
            response.put("response", "Pokémon con id " + id + " borrado correctamente");
            return response;
        } else {
            // Handle the case where the Pokemon with the given ID does not exist
            Map<String, String> response = new HashMap<>();
            response.put("response", "Pokémon con id " + id + " no encontrado");
            return response;
        }
    }
}

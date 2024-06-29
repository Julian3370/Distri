package com.app.poke.services;

import com.app.poke.interfaces.PokemonRepository;
import com.app.poke.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}

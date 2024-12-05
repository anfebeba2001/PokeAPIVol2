package com.AndresBejarano.PokeAPIVol2.Controllers;


import com.AndresBejarano.PokeAPIVol2.DTO.Request.PokemonRequest;


import com.AndresBejarano.PokeAPIVol2.DTO.Response.PokemonResponse;


import com.AndresBejarano.PokeAPIVol2.Services.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    @PostMapping("/add")
    public ResponseEntity<PokemonResponse> addPokemon(@RequestBody PokemonRequest pokemonRequest)
    {
        List<PokemonRequest> pokemonRequestList = new ArrayList<>();
        pokemonRequestList.add(pokemonRequest);
        return ResponseEntity.ok(pokemonService.add(pokemonRequestList).get(0));
    }
    @PostMapping("/batch")
    public ResponseEntity<List<PokemonResponse>> addAllPokemons(@RequestBody List<PokemonRequest> pokemonRequestList)
    {
        return ResponseEntity.ok(pokemonService.add(pokemonRequestList));
    }
}

package com.AndresBejarano.PokeAPIVol2.Services;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.PokemonRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.PokemonResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PokemonService {
    List<PokemonResponse> add(List<PokemonRequest> listOfPokemon);
}

package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;

import com.AndresBejarano.PokeAPIVol2.Controllers.PokemonController;
import com.AndresBejarano.PokeAPIVol2.DTO.Request.PokemonRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.PokemonResponse;
import com.AndresBejarano.PokeAPIVol2.Model.Pokemon;
import com.AndresBejarano.PokeAPIVol2.Respositories.PokemonRepository;
import com.AndresBejarano.PokeAPIVol2.Services.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final double kgToPoundValue = 2.35;
    private final double cmToFeetValue = 30.45;
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonResponse> add(List<PokemonRequest> listOfPokemon)
    {
        return listOfPokemon.stream().map(
                pokemonRequest -> mapEntityToResponse(pokemonRepository.save(
                        mapRequestToEntity(pokemonRequest)))).collect(Collectors.toList());
    }

    private Pokemon mapRequestToEntity(PokemonRequest pokemonRequest) {

        return Pokemon.builder()
                .name(pokemonRequest.getName())
                .base_experience(pokemonRequest.getBase_experience())
                .weight(pokemonRequest.getWeight() / kgToPoundValue)
                .height(pokemonRequest.getHeight() / cmToFeetValue)
                .build();
    }
    private PokemonResponse mapEntityToResponse(Pokemon pokemon) {
        return PokemonResponse.builder()
                .name(pokemon.getName())
                .base_experience(pokemon.getBase_experience())
                .weight(pokemon.getWeight() * kgToPoundValue)
                .height(pokemon.getHeight() * cmToFeetValue)
                .build();
    }
}

package com.AndresBejarano.PokeAPIVol2.Respositories;

import com.AndresBejarano.PokeAPIVol2.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}

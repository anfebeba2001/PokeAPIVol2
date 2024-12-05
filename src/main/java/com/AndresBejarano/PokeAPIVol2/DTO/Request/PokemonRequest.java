package com.AndresBejarano.PokeAPIVol2.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequest {
    private String name;
    private double base_experience;
    private double height;
    private double weight;

}

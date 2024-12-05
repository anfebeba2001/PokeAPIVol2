package com.AndresBejarano.PokeAPIVol2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemon_ability")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokemonAbility {

    @Id
    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @Id
    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Ability ability;
}

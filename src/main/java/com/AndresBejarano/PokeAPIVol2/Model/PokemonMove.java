package com.AndresBejarano.PokeAPIVol2.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon_move")
public class PokemonMove {

    @Id
    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @Id
    @ManyToOne
    @JoinColumn(name = "move_id")
    private Move move;

}
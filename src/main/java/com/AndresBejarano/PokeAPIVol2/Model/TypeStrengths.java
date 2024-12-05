package com.AndresBejarano.PokeAPIVol2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type_strengths")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeStrengths {
    @Id
    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    @Id
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type weakness;

}

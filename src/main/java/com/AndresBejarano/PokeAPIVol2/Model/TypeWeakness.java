package com.AndresBejarano.PokeAPIVol2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type_waknesses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeWeakness {

    @Id
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @Id
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type weakness;

    // Getters and setters
}
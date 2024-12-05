package com.AndresBejarano.PokeAPIVol2.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityRequest {
    private String name;
    private String description;
    private String effect;
}

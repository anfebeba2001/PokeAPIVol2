package com.AndresBejarano.PokeAPIVol2.DTO.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityResponse {
    private String name;
    private String description;
}

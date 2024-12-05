package com.AndresBejarano.PokeAPIVol2.Mappers;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.AndresBejarano.PokeAPIVol2.Model.Ability;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AbilityMapper {
    public static Ability mapRequestToEntity(AbilityRequest abilityRequest) {
        return Ability.builder()
                .name(abilityRequest.getName())
                .description(abilityRequest.getDescription())
                .effect(abilityRequest.getEffect())
                .build();
    }
    public static AbilityResponse mapEntityToResponse(Ability ability) {
        return AbilityResponse.builder()
                .name(ability.getName())
                .description(ability.getDescription())
                .build();
    }
}

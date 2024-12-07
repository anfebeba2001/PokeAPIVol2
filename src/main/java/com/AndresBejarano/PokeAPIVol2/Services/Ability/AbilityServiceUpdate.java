package com.AndresBejarano.PokeAPIVol2.Services.Ability;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AbilityServiceUpdate {
    AbilityResponse modify(int abilityId, AbilityRequest abilityRequest);


    AbilityResponse modifyPartially(int abilityId, AbilityRequest abilityRequest) throws JsonProcessingException;

}

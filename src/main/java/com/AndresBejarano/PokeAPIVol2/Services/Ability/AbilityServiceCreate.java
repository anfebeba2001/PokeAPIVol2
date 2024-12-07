package com.AndresBejarano.PokeAPIVol2.Services.Ability;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;

import java.util.List;

public interface AbilityServiceCreate {
    List<AbilityResponse> add(List<AbilityRequest> abilityRequests);
}

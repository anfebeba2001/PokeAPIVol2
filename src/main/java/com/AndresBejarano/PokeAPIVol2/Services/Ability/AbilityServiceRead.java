package com.AndresBejarano.PokeAPIVol2.Services.Ability;

import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;

import java.util.List;

public interface AbilityServiceRead {
    AbilityResponse get(int i);

    List<AbilityResponse> getAll();
}

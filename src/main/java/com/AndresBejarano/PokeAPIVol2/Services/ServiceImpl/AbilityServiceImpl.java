package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.AndresBejarano.PokeAPIVol2.Mappers.AbilityMapper;
import com.AndresBejarano.PokeAPIVol2.Model.Ability;

import com.AndresBejarano.PokeAPIVol2.Respositories.AbilityRepository;
import com.AndresBejarano.PokeAPIVol2.Services.AbilityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AbilityServiceImpl implements AbilityService {
    private final AbilityRepository abilityRepository;
    public AbilityServiceImpl(AbilityRepository abilityRepository)
    {
        this.abilityRepository = abilityRepository;
    }
    public List<AbilityResponse> add(List<AbilityRequest> abilityRequests) {

        return abilityRequests.parallelStream()
                .map(AbilityMapper::mapRequestToEntity)
                .map(abilityRepository::save)
                .map(AbilityMapper::mapEntityToResponse)
                .toList();
    }


}

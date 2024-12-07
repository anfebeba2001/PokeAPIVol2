package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.AndresBejarano.PokeAPIVol2.Mappers.AbilityMapper;
import com.AndresBejarano.PokeAPIVol2.Mappers.AbilityPatcher;
import com.AndresBejarano.PokeAPIVol2.Respositories.AbilityRepository;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceCreate;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceDelete;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceRead;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service

public class AbilityServiceImpl implements AbilityServiceCreate,
         AbilityServiceRead,
        AbilityServiceUpdate,
        AbilityServiceDelete {

    private final AbilityRepository abilityRepository;


    public AbilityServiceImpl(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    public List<AbilityResponse> add(List<AbilityRequest> abilityRequests) {

        return abilityRequests.stream()
                .map(AbilityMapper::mapRequestToEntity)
                .map(abilityRepository::save)
                .map(AbilityMapper::mapEntityToResponse)
                .toList();
    }

    public AbilityResponse get(int id) {
        return abilityRepository
                .findById((long) id)
                .map(AbilityMapper::mapEntityToResponse)
                .orElse(null);
    }

    public List<AbilityResponse> getAll() {
        return abilityRepository
                .findAll()
                .stream()
                .map(AbilityMapper::mapEntityToResponse)
                .toList();
    }


    public AbilityResponse modifyPartially(int abilityId, AbilityRequest abilityRequest){

        return abilityRepository.findById((long) abilityId)
                .map(foundAbility -> AbilityPatcher.patchingFoundAbility(abilityRequest, foundAbility))
                .map(abilityRepository::save)
                .map(AbilityMapper::mapEntityToResponse)
                .orElse(null);

    }

    public void delete(int abilityId) {
        abilityRepository.deleteById((long) abilityId);
    }

    public AbilityResponse modify(int abilityId, AbilityRequest abilityRequest) {
        return abilityRepository
                .findById((long) abilityId)
                .map(foundAbility -> AbilityMapper.updateEntity(
                        foundAbility,
                        abilityRequest))
                .map(abilityRepository::save)
                .map(AbilityMapper::mapEntityToResponse)
                .orElse(null);

    }


}

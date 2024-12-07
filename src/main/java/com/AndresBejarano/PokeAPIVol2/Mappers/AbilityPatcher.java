package com.AndresBejarano.PokeAPIVol2.Mappers;


import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.Model.Ability;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Map;
import java.util.stream.Collectors;

public class AbilityPatcher {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Map.Entry<String, Object> compare(Map.Entry<String, Object> fieldToPatch, Map<String, Object> abilityRequestMap) {

        if (abilityRequestMap.containsKey(fieldToPatch.getKey()) && abilityRequestMap.get(fieldToPatch.getKey()) != null) {
            return Map.entry(fieldToPatch.getKey(), abilityRequestMap.get(fieldToPatch.getKey()));
        }
        return fieldToPatch;
    }

    public static Ability patchingFoundAbility(AbilityRequest abilityRequest, Ability foundAbility) {
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> foundAbilityMap = objectMapper.convertValue(foundAbility, new TypeReference<>() {
        });
        Map<String, Object> abilityRequestMap = objectMapper.convertValue(abilityRequest, new TypeReference<>() {
        });

        Map<String, Object> foundAbilityMapPatched = foundAbilityMap.entrySet()
                .stream()
                .map(entry -> compare(entry, abilityRequestMap))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return objectMapper.convertValue(foundAbilityMapPatched, Ability.class);
    }


}

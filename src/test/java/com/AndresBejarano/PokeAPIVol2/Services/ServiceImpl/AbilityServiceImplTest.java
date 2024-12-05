package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;


import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.AndresBejarano.PokeAPIVol2.Model.Ability;
import com.AndresBejarano.PokeAPIVol2.Respositories.AbilityRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AbilityServiceImplTest {
    @Mock
    private AbilityRepository abilityRepository;
    @InjectMocks
    private AbilityServiceImpl abilityServiceImpl;

    @Test
    public void AbilityService_AddAbility_ReturnsAbilityResponseList()
    {
        Ability sampleAbilityEntity = Ability
                .builder()
                .name("Sample Ability")
                .description("Sample Ability Description")
                .effect("Sample Ability Effect")
                .build();
        Ability sampleAbilityEntity2 = Ability
                .builder()
                .name("Sample Ability2")
                .description("Sample Ability Description2")
                .effect("Sample Ability Effect2")
                .build();
        AbilityRequest sampleAbilityRequest = AbilityRequest
                .builder()
                .name("Sample Ability")
                .description("Sample Ability Description")
                .effect("Sample Ability Effect")
                .build();
        AbilityRequest sampleAbilityRequest2 = AbilityRequest
                .builder()
                .name("Sample Ability2")
                .description("Sample Ability Description2")
                .effect("Sample Ability Effect2")
                .build();


        when(abilityRepository.save(Mockito.any(Ability.class))).thenReturn(sampleAbilityEntity2).thenReturn(sampleAbilityEntity);


        List<AbilityRequest> requests = List.of(sampleAbilityRequest,sampleAbilityRequest2);
        System.out.println(requests);
        List<AbilityResponse> responses = abilityServiceImpl.add(requests);

        System.out.println(responses);
        AbilityResponse sampleAbilityResponse = AbilityResponse
                .builder()
                .name("Sample Ability")
                .description("Sample Ability Description")
                .build();
        AbilityResponse sampleAbilityResponse2 = AbilityResponse
                .builder()
                .name("Sample Ability2")
                .description("Sample Ability Description2")
                .build();
        assertEquals(sampleAbilityResponse, responses.get(0));
        assertEquals(sampleAbilityResponse2, responses.get(1));
    }
}
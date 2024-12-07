package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.AndresBejarano.PokeAPIVol2.Mappers.AbilityMapper;
import com.AndresBejarano.PokeAPIVol2.Mappers.AbilityPatcher;
import com.AndresBejarano.PokeAPIVol2.Model.Ability;
import com.AndresBejarano.PokeAPIVol2.Respositories.AbilityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AbilityServiceImplTest {
    @Mock
    private AbilityRepository abilityRepository;
    @InjectMocks
    private AbilityServiceImpl abilityServiceImpl;

    @Test
    public void AbilityService_AddAbility_ReturnsAbilityResponseList() {
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

        List<AbilityRequest> requests = List.of(sampleAbilityRequest, sampleAbilityRequest2);
        when(abilityRepository.save(sampleAbilityEntity)).thenReturn(sampleAbilityEntity);
        when(abilityRepository.save(sampleAbilityEntity2)).thenReturn(sampleAbilityEntity2);
        List<AbilityResponse> responses = abilityServiceImpl.add(requests);


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

    @Test
    public void AbilityService_GetOneAbility_ReturnsOneAbilityResponse() {
        int idToSearch = 8;
        Ability foundAbilityEntity = Ability
                .builder()
                .id((long) idToSearch)
                .effect("Sample Ab Effect")
                .name("Sample ab NAME")
                .description("Sample ab DESC")
                .build();


        when(abilityRepository.findById(foundAbilityEntity.getId()))
                .thenReturn(Optional.of(foundAbilityEntity));

        AbilityResponse abilityResponse = abilityServiceImpl.get(Math.toIntExact(foundAbilityEntity.getId()));

        AbilityResponse expectedResponse = AbilityResponse
                .builder()
                .name("Sample ab NAME")
                .description("Sample ab DESC")
                .build();

        assertEquals(expectedResponse, abilityResponse);

    }

    @Test
    public void AbilityService_GetOneAbility_ReturnsNull() {
        int idToSearch = 5;
        Ability foundAbilityEntity = Ability
                .builder()
                .id((long) idToSearch)
                .effect("Sample Ab Effect")
                .name("Sample ab NAME")
                .description("Sample ab DESC")
                .build();


        when(abilityRepository.findById(foundAbilityEntity.getId()))
                .thenReturn(Optional.empty());

        AbilityResponse abilityResponse = abilityServiceImpl.get(Math.toIntExact(foundAbilityEntity.getId()));

        assertNull(abilityResponse);
    }

    @Test
    public void AbilityService_ModifyAbilityComplete_ReturnsAbilityResponse() {
        int idToSearch = 5;
        Ability foundAbilityEntity = Ability
                .builder()
                .id((long) idToSearch)
                .effect("Sample Ab Effect")
                .name("Sample ab NAME")
                .description("Sample ab DESC")
                .build();

        AbilityRequest modifiedAbilityRequest = AbilityRequest
                .builder()
                .effect("Sample Ab Effect new")
                .name("Sample ab NAME new")
                .description("Sample ab DESC new")
                .build();

        Ability modifiedAbilityEntity = Ability
                .builder()
                .effect("Sample Ab Effect new")
                .name("Sample ab NAME new")
                .description("Sample ab DESC new")
                .build();

        when(abilityRepository.findById((long) idToSearch))
                .thenReturn(Optional.of(foundAbilityEntity));

        when(abilityRepository.save(AbilityMapper.updateEntity(foundAbilityEntity, modifiedAbilityRequest)))
                .thenReturn(modifiedAbilityEntity);

        AbilityResponse modifiedAbilityEntityResponse =
                abilityServiceImpl.modify(idToSearch, modifiedAbilityRequest);

        AbilityResponse modifiedAbilityEntityExpected = AbilityResponse
                .builder()
                .name("Sample ab NAME new")
                .description("Sample ab DESC new")
                .build();

        assertEquals(modifiedAbilityEntityExpected, modifiedAbilityEntityResponse);
    }

    @Test
    public void AbilityService_ModifyAbilityComplete_ReturnsNull() {
        int idToSearch = 5;
        when(abilityRepository.findById((long) idToSearch)).thenReturn(Optional.empty());
        AbilityRequest modifiedAbilityRequest = AbilityRequest
                .builder()
                .effect("Sample Ab Effect new")
                .name("Sample ab NAME new")
                .description("Sample ab DESC new")
                .build();
        AbilityResponse abilityResponse = abilityServiceImpl.modify(idToSearch, modifiedAbilityRequest);
        assertNull(abilityResponse);
    }

    @Test
    public void AbilityService_PatchAbility_ReturnAbilityResponse() {
        int idToSearch = 4;
        Ability foundAbility = Ability
                .builder()
                .id((long) idToSearch)
                .effect("Sample Ab Effect")
                .name("Sample ab NAME")
                .created_at(LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000))
                .updated_at(LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000))
                .description("Sample ab DESC")
                .build();


        AbilityRequest patch = AbilityRequest
                .builder()
                .description("Brand New Cool Desc B)")
                .build();

        Ability foundAbilityPatched = AbilityPatcher.patchingFoundAbility(patch, foundAbility);


        when(abilityRepository.findById((long) idToSearch)).thenReturn(Optional.of(foundAbility));

        when(abilityRepository.save(foundAbilityPatched))
                .thenReturn(foundAbilityPatched);


        AbilityResponse abilityResponse = abilityServiceImpl.modifyPartially(idToSearch, patch);
        AbilityResponse expected = AbilityResponse
                .builder()
                .name("Sample ab NAME")
                .description("Brand New Cool Desc B)")
                .build();

        assertEquals(expected, abilityResponse);

    }

    @Test
    public void AbilityService_PatchAbility_ReturnNull() {
        int idToSearch = 4;


        AbilityRequest patch = AbilityRequest
                .builder()
                .description("Brand New Cool Desc B)")
                .build();


        when(abilityRepository.findById((long) idToSearch)).thenReturn(Optional.empty());
        AbilityResponse abilityResponse = abilityServiceImpl.modifyPartially(idToSearch, patch);


        assertNull(abilityResponse);

    }

    @Test
    void AbilityService_GetAbility_ReturnList() {

        List<Ability> AbilitiesEntities = List.of(
                Ability
                        .builder()
                        .name("Sample Ability")
                        .description("Sample Ability Description")
                        .effect("Sample Ability Effect")
                        .build() ,
                Ability
                        .builder()
                        .name("Sample Ability2")
                        .description("Sample Ability Description2")
                        .effect("Sample Ability Effect2")
                        .build()
        );
        when(abilityRepository.findAll()).thenReturn(AbilitiesEntities);
        List<AbilityResponse> abilityResponses = abilityServiceImpl.getAll();
        List<AbilityResponse> expectedAbilitiesResponse = List.of(
                AbilityResponse
                        .builder()
                        .name("Sample Ability")
                        .description("Sample Ability Description")
                        .build() ,
                AbilityResponse
                        .builder()
                        .name("Sample Ability2")
                        .description("Sample Ability Description2")
                        .build()
        );
        assertEquals(expectedAbilitiesResponse, abilityResponses);

    }

}
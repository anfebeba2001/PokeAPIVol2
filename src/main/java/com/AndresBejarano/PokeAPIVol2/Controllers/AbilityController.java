package com.AndresBejarano.PokeAPIVol2.Controllers;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceCreate;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceDelete;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceRead;
import com.AndresBejarano.PokeAPIVol2.Services.Ability.AbilityServiceUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ability")
public class AbilityController {
    @GetMapping("greet")
    public String Greeting()
    {
        return "hi";
    }
    private final AbilityServiceCreate abilityServiceCreate;
    private final AbilityServiceRead abilityServiceRead;
    private final AbilityServiceUpdate abilityServiceUpdate;
    private final AbilityServiceDelete abilityServiceDelete;
    public AbilityController(AbilityServiceCreate abilityServiceCreate,
                             AbilityServiceRead abilityServiceRead,
                             AbilityServiceUpdate abilityServiceUpdate,
                             AbilityServiceDelete abilityServiceDelete) {
        this.abilityServiceCreate = abilityServiceCreate;
        this.abilityServiceRead = abilityServiceRead;
        this.abilityServiceUpdate = abilityServiceUpdate;
        this.abilityServiceDelete = abilityServiceDelete;
    }
    @PostMapping
    public ResponseEntity<AbilityResponse> addAbility(@RequestBody AbilityRequest abilityRequest)
    {
        return ResponseEntity.ok(abilityServiceCreate.add(List.of(abilityRequest)).get(0));
    }
    @PostMapping("/batch")
    public ResponseEntity<List<AbilityResponse>> addAllAbilities(@RequestBody List<AbilityRequest> abilityRequestList)
    {
        return ResponseEntity.ok(abilityServiceCreate.add(abilityRequestList));
    }
    @GetMapping
    public ResponseEntity<List<AbilityResponse>> getAllAAbilities()
    {
        return ResponseEntity.ok(abilityServiceRead.getAll());
    }
    @GetMapping("{abilityId}")
    public ResponseEntity<AbilityResponse> getOneAbility(@PathVariable int abilityId) {
        return Optional
                .ofNullable(abilityServiceRead.get(abilityId))
                .map(abilityResponse -> ResponseEntity.ok().body(abilityResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("{abilityId}")
    public ResponseEntity<AbilityResponse> modifyAbility(@RequestBody AbilityRequest abilityRequest,
                                                            @PathVariable int abilityId){
        return Optional
                .ofNullable(abilityServiceUpdate.modify(abilityId, abilityRequest))
                .map(abilityResponse -> ResponseEntity.ok().body(abilityResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PatchMapping("{abilityId}")
    public ResponseEntity<AbilityResponse> modifyPartiallyAbility(@RequestBody AbilityRequest abilityRequest,
                                                            @PathVariable int abilityId) throws JsonProcessingException {
        return Optional
                .ofNullable(abilityServiceUpdate.modifyPartially(abilityId, abilityRequest))
                .map(abilityResponse -> ResponseEntity.ok().body(abilityResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("{abilityId}")
    public ResponseEntity<Boolean> deleteAbility(@PathVariable int abilityId) {
        AbilityResponse foundAbilityRequest = abilityServiceRead.get(abilityId);
        if(foundAbilityRequest == null) {
            abilityServiceDelete.delete(abilityId);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}

package com.AndresBejarano.PokeAPIVol2.Controllers;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.AbilityRequest;

import com.AndresBejarano.PokeAPIVol2.DTO.Response.AbilityResponse;

import com.AndresBejarano.PokeAPIVol2.Services.AbilityService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ability")
public class AbilityController {
    @GetMapping("greet")
    public String Greeting()
    {
        return "hi";
    }
    private final AbilityService abilityService;
    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }
    @PostMapping
    public ResponseEntity<AbilityResponse> addAbility(@RequestBody AbilityRequest abilityRequest)
    {
        return ResponseEntity.ok(abilityService.add(List.of(abilityRequest)).get(0));
    }
    @PostMapping("/batch")
    public ResponseEntity<List<AbilityResponse>> addAllAbilities(@RequestBody List<AbilityRequest> abilityRequestList)
    {
        return ResponseEntity.ok(abilityService.add(abilityRequestList));
    }
}

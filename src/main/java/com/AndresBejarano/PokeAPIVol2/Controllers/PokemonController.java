package com.AndresBejarano.PokeAPIVol2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pokemons")
public class PokemonController {
    @PostMapping("/Debugging")
    public ResponseEntity<String> debugHelper(@RequestBody String test)
    {
        return new ResponseEntity<>("Llegamos, Major Tom " + test, HttpStatus.OK);
    }
}

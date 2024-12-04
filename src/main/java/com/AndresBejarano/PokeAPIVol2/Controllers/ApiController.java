package com.AndresBejarano.PokeAPIVol2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/DebuggingPermitAll")
    public String apiRoot() {
        return "Hi there!";
    }
}
package com.AndresBejarano.PokeAPIVol2.Controllers;


import com.AndresBejarano.PokeAPIVol2.DTO.Request.TypeRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.TypeResponse;
import com.AndresBejarano.PokeAPIVol2.Services.TypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/type")
public class TypeController {
    private final TypeService typeService;
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @PostMapping("/add")
    public ResponseEntity<TypeResponse> addType(@RequestBody TypeRequest typeRequest)
    {
        List<TypeRequest> typeRequestList = new ArrayList<>();
        typeRequestList.add(typeRequest);
        return ResponseEntity.ok(typeService.add(typeRequestList).get(0));
    }
    @PostMapping("/batch")
    public ResponseEntity<List<TypeResponse>> addAllTypes(@RequestBody List<TypeRequest> typeRequestList)
    {
        return ResponseEntity.ok(typeService.add(typeRequestList));
    }
}

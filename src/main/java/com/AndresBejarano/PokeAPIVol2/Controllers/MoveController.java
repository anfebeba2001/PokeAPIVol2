package com.AndresBejarano.PokeAPIVol2.Controllers;


import com.AndresBejarano.PokeAPIVol2.DTO.Request.MoveRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.MoveResponse;
import com.AndresBejarano.PokeAPIVol2.Services.MoveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/move")
public class MoveController {
    private final MoveService moveService;
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }
    @PostMapping("/add")
    public ResponseEntity<MoveResponse> addMove(@RequestBody MoveRequest moveRequest)
    {
        List<MoveRequest> moveRequestList = new ArrayList<>();
        moveRequestList.add(moveRequest);
        return ResponseEntity.ok(moveService.add(moveRequestList).get(0));
    }
    @PostMapping("/batch")
    public ResponseEntity<List<MoveResponse>> addAllMoves(@RequestBody List<MoveRequest> moveRequestList)
    {
        return ResponseEntity.ok(moveService.add(moveRequestList));
    }
}

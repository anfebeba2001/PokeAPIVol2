package com.AndresBejarano.PokeAPIVol2.Services;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.MoveRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.MoveResponse;

import java.util.List;

public interface MoveService {
    List<MoveResponse> add(List<MoveRequest> moveRequestList);
}

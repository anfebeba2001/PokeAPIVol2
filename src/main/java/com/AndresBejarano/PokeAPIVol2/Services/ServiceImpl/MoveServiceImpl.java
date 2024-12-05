package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.MoveRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.MoveResponse;
import com.AndresBejarano.PokeAPIVol2.Services.MoveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveServiceImpl implements MoveService {
    public List<MoveResponse> add(List<MoveRequest> moveRequestList) {
        return List.of();
    }
}

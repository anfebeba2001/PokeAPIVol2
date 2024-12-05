package com.AndresBejarano.PokeAPIVol2.Services.ServiceImpl;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.TypeRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.TypeResponse;
import com.AndresBejarano.PokeAPIVol2.Services.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Override
    public List<TypeResponse> add(List<TypeRequest> typeRequestList) {
        return List.of();
    }
}

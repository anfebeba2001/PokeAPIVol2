package com.AndresBejarano.PokeAPIVol2.Services;

import com.AndresBejarano.PokeAPIVol2.DTO.Request.TypeRequest;
import com.AndresBejarano.PokeAPIVol2.DTO.Response.TypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TypeService {


    List<TypeResponse> add(List<TypeRequest> typeRequestList);
}

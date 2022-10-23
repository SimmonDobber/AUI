package com.example.beer.mappers;

import com.example.beer.dtos.ReadAllBeerResponseDTO;
import com.example.beer.dtos.ReadBeerResponseDTO;
import com.example.beer.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class BeerMapper {

    public static ReadBeerResponseDTO toResponseDto(Beer beer, String brandName) {
        return beer == null ? null : ReadBeerResponseDTO.builder()
                .id(beer.getId())
                .name(beer.getName())
                .voltage(beer.getVoltage())
                .brandName(brandName)
                .build();
    }

    public static ReadAllBeerResponseDTO toResponseDtoList(List<Beer> beers, List<String> brandNames) {
        List<ReadBeerResponseDTO> dtos = new ArrayList<>();
        for(int i = 0; i < beers.size(); i++) {
            dtos.add(toResponseDto(beers.get(i), brandNames.get(i)));
        }
        return new ReadAllBeerResponseDTO(dtos);
    }
}

package com.example.aui.mappers;


import com.example.aui.dtos.beer.ReadAllBeerResponseDTO;
import com.example.aui.dtos.beer.ReadBeerResponseDTO;
import com.example.aui.models.Beer;

import java.util.List;

public class BeerMapper {

    public static ReadBeerResponseDTO toResponseDto(Beer beer) {
        return beer == null ? null : ReadBeerResponseDTO.builder()
                .id(beer.getId())
                .name(beer.getName())
                .voltage(beer.getVoltage())
                .brandName(beer.getBrand().getName())
                .build();
    }

    public static ReadAllBeerResponseDTO toResponseDtoList(List<Beer> beers) {
        return new ReadAllBeerResponseDTO(beers.stream()
                .map(BeerMapper::toResponseDto)
                .toList());
    }
}

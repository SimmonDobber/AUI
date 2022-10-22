package com.example.aui.mappers;

import com.example.aui.dtos.beer.ReadAllBeerResponseDTO;
import com.example.aui.dtos.beer.ReadBeerResponseDTO;
import com.example.aui.dtos.brand.ReadAllBrandResponseDTO;
import com.example.aui.dtos.brand.ReadBrandResponseDTO;
import com.example.aui.models.Beer;
import com.example.aui.models.Brand;

import java.util.List;

public class BrandMapper {

    public static ReadBrandResponseDTO toResponseDto(Brand brand) {
        return brand == null ? null : ReadBrandResponseDTO.builder()
                .id(brand.getId())
                .name(brand.getName())
                .rating(brand.getRating())
                .beers(brand.getBeers().stream().map(Beer::getName).toList())
                .build();
    }

    public static ReadAllBrandResponseDTO toResponseDtoList(List<Brand> brands) {
        return brands == null ? null : new ReadAllBrandResponseDTO(brands.stream()
                .map(BrandMapper::toResponseDto)
                .toList());
    }

}

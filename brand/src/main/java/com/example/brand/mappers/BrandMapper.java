package com.example.brand.mappers;

import com.example.brand.dtos.ReadAllBrandResponseDTO;
import com.example.brand.dtos.ReadBrandResponseDTO;
import com.example.brand.models.BeerSimple;
import com.example.brand.models.Brand;

import java.util.List;

public class BrandMapper {

    public static ReadBrandResponseDTO toResponseDto(Brand brand) {
        return brand == null ? null : ReadBrandResponseDTO.builder()
                .id(brand.getId())
                .name(brand.getName())
                .rating(brand.getRating())
                .beers(brand.getBeers().stream().map(BeerSimple::getName).toList())
                .build();
    }

    public static ReadAllBrandResponseDTO toResponseDtoList(List<Brand> brands) {
        return brands == null ? null : new ReadAllBrandResponseDTO(brands.stream()
                .map(BrandMapper::toResponseDto)
                .toList());
    }

}

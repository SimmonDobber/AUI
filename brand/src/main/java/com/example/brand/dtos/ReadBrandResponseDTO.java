package com.example.brand.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadBrandResponseDTO {
    private Long id;
    private String name;
    private Double rating;
    private List<String> beers;
}

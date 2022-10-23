package com.example.beer.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadAllBeerResponseDTO {
    private List<ReadBeerResponseDTO> beers;
}

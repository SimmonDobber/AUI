package com.example.beer.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBeerRequestDTO {
    private String name;
    private Double voltage;
    private Long brandId;
}

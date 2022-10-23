package com.example.beer.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBeerRequestDTO {
    private Long id;
    private String name;
    private Double Voltage;
}

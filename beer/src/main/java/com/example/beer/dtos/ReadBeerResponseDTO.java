package com.example.beer.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadBeerResponseDTO {
    private Long id;
    private String name;
    private Double voltage;
    private String brandName;
}

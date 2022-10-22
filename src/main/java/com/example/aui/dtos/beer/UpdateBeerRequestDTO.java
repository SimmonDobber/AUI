package com.example.aui.dtos.beer;

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

package com.example.aui.dtos.beer;

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

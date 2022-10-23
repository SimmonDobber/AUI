package com.example.brand.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadAllBrandResponseDTO {
    private List<ReadBrandResponseDTO> brands;
}

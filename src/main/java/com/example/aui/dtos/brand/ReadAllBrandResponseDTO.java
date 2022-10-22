package com.example.aui.dtos.brand;

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

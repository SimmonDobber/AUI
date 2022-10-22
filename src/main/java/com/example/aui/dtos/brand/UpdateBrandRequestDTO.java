package com.example.aui.dtos.brand;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandRequestDTO {
    private Long id;
    private String name;
    private Double rating;
}

package com.example.aui.dtos.brand;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequestDTO {
    private String name;
    private Double rating;
}

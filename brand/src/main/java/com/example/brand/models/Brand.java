package com.example.brand.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "PUBLIC", name = "BRANDS")
public class Brand {

    @Transient
    private static Long brandIdSeq = 0L;
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rating;
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<BeerSimple> beers;

    @Builder
    public Brand(String name, Double rating) {
        this.id = brandIdSeq++;
        this.name = name;
        this.rating = rating;
        this.beers = new ArrayList<>();
    }
}

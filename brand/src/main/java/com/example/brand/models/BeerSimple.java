package com.example.brand.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "PUBLIC", name = "BEERS")
public class BeerSimple {

    @Transient
    private static Long beerIdSeq = 0L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Builder
    public BeerSimple(String name) {
        this.id = beerIdSeq++;
        this.name = name;
    }
}

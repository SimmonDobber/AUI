package com.example.beer.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "PUBLIC", name = "BEERS")
public class Beer {

    @Transient
    private static Long beerIdSeq = 0L;
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double voltage;
    private Long brandId;

    @Builder
    public Beer(String name, Double voltage, Long brandId) {
        this.id = beerIdSeq++;
        this.name = name;
        this.voltage = voltage;
        this.brandId = brandId;
    }
}

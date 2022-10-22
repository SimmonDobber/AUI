package com.example.aui.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "PUBLIC", name = "BEERS")
public class Beer {

    @Transient
    private static Long beerIdSeq = 0L;
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double voltage;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @Builder
    public Beer(String name, Double voltage, Brand brand) {
        this.id = beerIdSeq++;
        this.name = name;
        this.voltage = voltage;
        this.brand = brand;
    }
}

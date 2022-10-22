package com.example.aui.models;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
public class Beer {

    private static Long beerIdSeq = 0L;
    @Id
    private Long id;
    private String name;
    private Double voltage;
    private Brand brand;

    @Builder
    public Beer(String name, Double voltage, Brand brand) {
        this.id = beerIdSeq++;
        this.name = name;
        this.voltage = voltage;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", voltage=" + voltage +
                ", brand=" + brand.getName() +
                '}';
    }
}

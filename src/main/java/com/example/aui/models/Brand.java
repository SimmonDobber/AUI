package com.example.aui.models;

import lombok.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Brand {

    private static Long brandIdSeq = 0L;
    @Id
    private Long id;
    private String name;
    private Double rating;
    private List<Beer> beers;

    @Builder
    public Brand(String name, Double rating) {
        this.id = brandIdSeq++;
        this.name = name;
        this.rating = rating;
        this.beers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", beers=" + beers.stream().map(Beer::getName).toList() +
                '}';
    }
}

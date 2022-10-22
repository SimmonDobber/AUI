package com.example.aui.components;

import com.example.aui.models.Beer;
import com.example.aui.models.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class BeerComponent {

    private List<Beer> beers;
    private List<Brand> brands;

    public BeerComponent() {
        this.beers = new ArrayList<>();
        this.brands = new ArrayList<>();
    }
}

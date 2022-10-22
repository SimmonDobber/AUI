package com.example.aui.repositories;

import com.example.aui.components.BeerComponent;
import com.example.aui.models.Beer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class BeerRepository {

    private final BeerComponent beerComponent;

    public void save(Beer beer) {
        if(beerComponent.getBrands().contains(beer.getBrand())) {
            List<Beer> beers = new ArrayList<>(beerComponent.getBeers());
            beers.add(beer);
            beerComponent.setBeers(beers);
            beer.getBrand().getBeers().add(beer);
        }
    }

    public Beer getById(Long id) {
        return beerComponent.getBeers().stream()
                .filter(beer -> beer.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Beer getByName(String name) {
        return beerComponent.getBeers().stream()
                .filter(beer -> beer.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public List<Beer> getAll() {
        return beerComponent.getBeers();
    }

    public void delete(Beer beer) {
        if(beerComponent.getBeers().contains(beer)) {
            beerComponent.getBeers().remove(beer);
            beer.getBrand().getBeers().remove(beer);
        }
    }
}

package com.example.aui.repositories;

import com.example.aui.components.BeerComponent;
import com.example.aui.models.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class BrandRepository {

    private final BeerComponent beerComponent;

    public void save(Brand brand) {
        beerComponent.getBrands().add(brand);
    }

    public Brand getById(Long id) {
        return beerComponent.getBrands().stream()
                .filter(brand -> brand.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Brand getByName(String name) {
        return beerComponent.getBrands().stream()
                .filter(brand -> brand.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public List<Brand> getAll() {
        return beerComponent.getBrands();
    }

    public void delete(Brand brand) {
        if(beerComponent.getBrands().contains(brand)) {
            beerComponent.setBeers(beerComponent.getBeers().stream()
                    .filter(beer -> !beer.getBrand().equals(brand))
                    .toList());
            beerComponent.getBrands().remove(brand);
        }
    }

}

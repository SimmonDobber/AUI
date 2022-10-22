package com.example.aui.services;

import com.example.aui.models.Beer;
import com.example.aui.repositories.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public void save(Beer beer) {
        beerRepository.save(beer);
    }

    public Beer getById(Long id) {
        return beerRepository.getById(id);
    }

    public Beer getByName(String name) {
        return beerRepository.getByName(name);
    }

    public List<Beer> getAll() {
        return beerRepository.getAll();
    }

    public void delete(Beer beer) {
       beerRepository.delete(beer);
    }
}

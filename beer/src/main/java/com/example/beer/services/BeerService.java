package com.example.beer.services;

import com.example.beer.dtos.CreateBeerRequestDTO;
import com.example.beer.dtos.ReadAllBeerResponseDTO;
import com.example.beer.dtos.ReadBeerResponseDTO;
import com.example.beer.dtos.UpdateBeerRequestDTO;
import com.example.beer.mappers.BeerMapper;
import com.example.beer.models.Beer;
import com.example.beer.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public boolean create(CreateBeerRequestDTO dto) {
        if (getBrandNameById(dto.getBrandId()) == null) {
            return false;
        }
        beerRepository.create(dto.getName(), dto.getVoltage(), dto.getBrandId());
        return true;
    }

    public ReadBeerResponseDTO read(Long id) {
        Beer beer = beerRepository.read(id);
        if(beer == null) {
            return null;
        }
        String brandName = getBrandNameById(beer.getBrandId());
        return BeerMapper.toResponseDto(beer, brandName);
    }

    public ReadAllBeerResponseDTO readAll() {
        List<Beer> beers = beerRepository.readAll();
        List<String> brandNames = beers.stream()
                .map(beer -> getBrandNameById(beer.getBrandId()))
                .toList();
        return BeerMapper.toResponseDtoList(beers, brandNames);
    }

    public boolean update(UpdateBeerRequestDTO dto) {
        if (read(dto.getId()) == null) {
            return false;
        }
        beerRepository.update(dto.getId(), dto.getName(), dto.getVoltage());
        return true;
    }

    public boolean delete(Long id) {
        if (read(id) == null) {
            return false;
        }
        beerRepository.delete(id);
        return true;
    }

    public List<String> getAllNamesByBrandId(Long id) {
        return beerRepository.getAllNamesByBrandId(id);
    }

    public void deleteAllByBrandId(Long id) {
        beerRepository.deleteAllByBrandId(id);
    }

    private String getBrandNameById(Long id) {
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/brand/name/{id}", String.class, id);
        return !Objects.equals(response.getBody(), "") ? response.getBody() : null;
    }
}

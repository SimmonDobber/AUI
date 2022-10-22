package com.example.aui.services;

import com.example.aui.dtos.beer.CreateBeerRequestDTO;
import com.example.aui.dtos.beer.ReadAllBeerResponseDTO;
import com.example.aui.dtos.beer.ReadBeerResponseDTO;
import com.example.aui.dtos.beer.UpdateBeerRequestDTO;
import com.example.aui.mappers.BeerMapper;
import com.example.aui.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BrandService brandService;

    @Autowired
    public BeerService(BeerRepository beerRepository, BrandService brandService) {
        this.beerRepository = beerRepository;
        this.brandService = brandService;
    }

    public boolean create(CreateBeerRequestDTO dto) {
        if(brandService.read(dto.getBrandId()) == null) {
            return false;
        }
        beerRepository.create(dto.getName(), dto.getVoltage(), dto.getBrandId());
        return true;
    }

    public ReadBeerResponseDTO read(Long id) {
        return BeerMapper.toResponseDto(beerRepository.read(id));
    }

    public ReadAllBeerResponseDTO readAll() {
        return BeerMapper.toResponseDtoList(beerRepository.readAll());
    }

    public boolean update(UpdateBeerRequestDTO dto) {
        if(read(dto.getId()) == null) {
            return false;
        }
        beerRepository.update(dto.getId(), dto.getName(), dto.getVoltage());
        return true;
    }

    public boolean delete(Long id) {
        if(read(id) == null) {
            return false;
        }
        beerRepository.delete(id);
        return true;
    }
}

package com.example.aui.services;

import com.example.aui.dtos.beer.ReadAllBeerResponseDTO;
import com.example.aui.dtos.beer.ReadBeerResponseDTO;
import com.example.aui.dtos.brand.CreateBrandRequestDTO;
import com.example.aui.dtos.brand.ReadAllBrandResponseDTO;
import com.example.aui.dtos.brand.ReadBrandResponseDTO;
import com.example.aui.dtos.brand.UpdateBrandRequestDTO;
import com.example.aui.mappers.BrandMapper;
import com.example.aui.models.Beer;
import com.example.aui.repositories.BeerRepository;
import com.example.aui.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BeerRepository beerRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository, BeerRepository beerRepository) {
        this.brandRepository = brandRepository;
        this.beerRepository = beerRepository;
    }

    public void create(CreateBrandRequestDTO dto) {
        brandRepository.create(dto.getName(), dto.getRating());
    }

    public ReadBrandResponseDTO read(Long id) {
        ReadBrandResponseDTO dto = BrandMapper.toResponseDto(brandRepository.read(id));
        if(dto != null) {
            dto.setBeers(beerRepository.searchAllByBrandId(id).stream().map(Beer::getName).toList());
        }
        return dto;
    }

    public ReadAllBrandResponseDTO readAll() {
        ReadAllBrandResponseDTO dtos = BrandMapper.toResponseDtoList(brandRepository.readAll());
        if(dtos != null) {
            for(ReadBrandResponseDTO dto : dtos.getBrands()) {
                dto.setBeers(beerRepository.searchAllByBrandId(dto.getId()).stream().map(Beer::getName).toList());
            }
        }
        return dtos;
    }

    public boolean update(UpdateBrandRequestDTO dto) {
        if(read(dto.getId()) == null) {
            return false;
        }
        brandRepository.update(dto.getId(), dto.getName(), dto.getRating());
        return true;
    }

    public boolean delete(Long id) {
        if(read(id) == null) {
            return false;
        }
        beerRepository.deleteAllByBrandId(id);
        brandRepository.delete(id);
        return true;
    }
}

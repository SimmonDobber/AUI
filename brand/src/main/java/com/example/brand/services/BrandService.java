package com.example.brand.services;

import com.example.brand.dtos.CreateBrandRequestDTO;
import com.example.brand.dtos.ReadAllBrandResponseDTO;
import com.example.brand.dtos.ReadBrandResponseDTO;
import com.example.brand.dtos.UpdateBrandRequestDTO;
import com.example.brand.mappers.BrandMapper;
import com.example.brand.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void create(CreateBrandRequestDTO dto) {
        brandRepository.create(dto.getName(), dto.getRating());
    }

    public ReadBrandResponseDTO read(Long id) {
        ReadBrandResponseDTO dto = BrandMapper.toResponseDto(brandRepository.read(id));
        if(dto != null) {
            dto.setBeers(getBeerNamesByBrandId(id));
        }
        return dto;
    }

    public ReadAllBrandResponseDTO readAll() {
        ReadAllBrandResponseDTO dtos = BrandMapper.toResponseDtoList(brandRepository.readAll());
        if(dtos != null) {
            for(ReadBrandResponseDTO dto : dtos.getBrands()) {
                dto.setBeers(getBeerNamesByBrandId(dto.getId()));
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
        deleteAllBeersByBrandId(id);
        brandRepository.delete(id);
        return true;
    }

    public String getNameById(Long id) {
        return brandRepository.getNameById(id);
    }

    private List<String> getBeerNamesByBrandId(Long id) {
        return new RestTemplate().getForObject("http://localhost:8081/beer/all/brand/{id}", List.class, id);
    }

    private void deleteAllBeersByBrandId(Long id) {
        new RestTemplate().delete("http://localhost:8081/beer/delete/{id}", id);
    }
}

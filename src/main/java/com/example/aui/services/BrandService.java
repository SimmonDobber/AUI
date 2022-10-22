package com.example.aui.services;

import com.example.aui.models.Brand;
import com.example.aui.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand getById(Long id) {
        return brandRepository.getById(id);
    }

    public Brand getByName(String name) {
        return brandRepository.getByName(name);
    }

    public List<Brand> getAll() {
        return brandRepository.getAll();
    }

    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }
}

package com.example.brand.controllers;

import com.example.brand.dtos.CreateBrandRequestDTO;
import com.example.brand.dtos.ReadAllBrandResponseDTO;
import com.example.brand.dtos.ReadBrandResponseDTO;
import com.example.brand.dtos.UpdateBrandRequestDTO;
import com.example.brand.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> create(@RequestBody CreateBrandRequestDTO dto) {
        brandService.create(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReadBrandResponseDTO> read(@PathVariable(name = "id") Long id) {
        ReadBrandResponseDTO dto = brandService.read(id);
        return new ResponseEntity<>(dto, dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<ReadAllBrandResponseDTO> read() {
        return new ResponseEntity<>(brandService.readAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody UpdateBrandRequestDTO dto) {
        return new ResponseEntity<>(brandService.update(dto) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(brandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/name/{brandId}")
    public ResponseEntity<String> getBrandNameById(@PathVariable Long brandId) {
        String name = brandService.getNameById(brandId);
        return new ResponseEntity<>(name != null ? name : "", HttpStatus.OK);
    }
}

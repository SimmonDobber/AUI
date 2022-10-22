package com.example.aui.controllers;

import com.example.aui.dtos.brand.CreateBrandRequestDTO;
import com.example.aui.dtos.brand.ReadAllBrandResponseDTO;
import com.example.aui.dtos.brand.ReadBrandResponseDTO;
import com.example.aui.dtos.brand.UpdateBrandRequestDTO;
import com.example.aui.services.BrandService;
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
}

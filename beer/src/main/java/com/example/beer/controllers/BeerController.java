package com.example.beer.controllers;

import com.example.beer.dtos.CreateBeerRequestDTO;
import com.example.beer.dtos.ReadAllBeerResponseDTO;
import com.example.beer.dtos.ReadBeerResponseDTO;
import com.example.beer.dtos.UpdateBeerRequestDTO;
import com.example.beer.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/beer")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> create(@RequestBody CreateBeerRequestDTO dto) {
        return new ResponseEntity<>(beerService.create(dto) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReadBeerResponseDTO> read(@PathVariable(name = "id") Long id) {
        ReadBeerResponseDTO dto = beerService.read(id);
        return new ResponseEntity<>(beerService.read(id), dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<ReadAllBeerResponseDTO> read() {
        return new ResponseEntity<>(beerService.readAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody UpdateBeerRequestDTO dto) {
        return new ResponseEntity<>(beerService.update(dto) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(beerService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/all/brand/{id}")
    public ResponseEntity<List<String>> getNamesByBrandId(@PathVariable Long id) {
        List<String> names = beerService.getAllNamesByBrandId(id);
        return new ResponseEntity<>(names, names != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteAllByBrandId(@PathVariable Long id) {
        beerService.deleteAllByBrandId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.aui.controllers;

import com.example.aui.dtos.beer.CreateBeerRequestDTO;
import com.example.aui.dtos.beer.ReadAllBeerResponseDTO;
import com.example.aui.dtos.beer.ReadBeerResponseDTO;
import com.example.aui.dtos.beer.UpdateBeerRequestDTO;
import com.example.aui.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

package com.example.aui.components;

import com.example.aui.models.Beer;
import com.example.aui.models.Brand;
import com.example.aui.repositories.BeerRepository;
import com.example.aui.repositories.BrandRepository;
import com.example.aui.services.BeerService;
import com.example.aui.services.BrandService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class InitializerComponent {

    public void initialize() {
        BeerComponent beerComponent = new BeerComponent();
        BeerRepository beerRepository = new BeerRepository(beerComponent);
        BrandRepository brandRepository = new BrandRepository(beerComponent);
        BeerService beerService = new BeerService(beerRepository);
        BrandService brandService = new BrandService(brandRepository);
        initializeBrandData(brandService);
        initializeBeerData(brandService, beerService);
        System.out.println(brandService.getAll());
        System.out.println(beerService.getAll());
        new RunnerComponent(brandService, beerService).run();
    }

    private void initializeBrandData(BrandService brandService) {
        brandService.save(Brand.builder()
                .name("Żywiec")
                .rating(8.1)
                .build());

        brandService.save(Brand.builder()
                .name("Tyskie")
                .rating(7.9)
                .build());
    }

    private void initializeBeerData(BrandService brandService, BeerService beerService) {
        beerService.save(Beer.builder()
                .name("Żywiec-ipa")
                .voltage(5.0)
                .brand(brandService.getByName("Żywiec"))
                .build());

        beerService.save(Beer.builder()
                .name("Żywiec-apa")
                .voltage(5.4)
                .brand(brandService.getByName("Żywiec"))
                .build());

        beerService.save(Beer.builder()
                .name("Tyskie-0.0%")
                .voltage(0.0)
                .brand(brandService.getByName("Tyskie"))
                .build());
    }
}

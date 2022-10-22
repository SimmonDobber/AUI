package com.example.aui.components;

import com.example.aui.models.Beer;
import com.example.aui.models.Brand;
import com.example.aui.services.BeerService;
import com.example.aui.services.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RunnerComponent {

    private final BrandService brandService;
    private final BeerService beerService;
    private final Scanner scanner;

    public RunnerComponent(BrandService brandService, BeerService beerService) {
        this.brandService = brandService;
        this.beerService = beerService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String command;
        listAllCommands();
        while(true) {
            command = scanner.next();
            if(command.equals("LIST")) {
                listAllCommands();
            } else if(command.equals("LIST_BRANDS")) {
                System.out.println(brandService.getAll());
            } else if(command.equals("LIST_BEERS")) {
                System.out.println(beerService.getAll());
            } else if(command.equals("ADD_BRAND")) {
                addBrand();
            } else if(command.equals("ADD_BEER")) {
                addBeer();
            } else if(command.equals("DELETE_BRAND")) {
                deleteBrand();
            } else if(command.equals("DELETE_BEER")) {
                deleteBeer();
            } else if(command.equals("QUIT")) {
                System.exit(0);
            }
        }
    }

    private void listAllCommands() {
        String commands = new StringBuilder()
                .append("Commands: \n")
                .append("LIST (lists all available commands) \n")
                .append("LIST_BRANDS (lists all brands) \n")
                .append("LIST_BEERS (lists all beers) \n")
                .append("ADD_BRAND brand_name brand_rating (adds new brand) \n")
                .append("ADD_BEER beer_name beer_voltage beer_brand_name (adds new beer) \n")
                .append("DELETE_BRAND brand_name (removes brand) \n")
                .append("DELETE_BEER beer_name (removes beer) \n")
                .append("QUIT (ends program)")
                .toString();
        System.out.println(commands);
    }

    private void addBrand() {
        String name = scanner.next();
        Double rating = scanner.nextDouble();
        Brand brand = Brand.builder()
                .name(name)
                .rating(rating)
                .build();
        brandService.save(brand);
    }

    private void addBeer() {
        String name = scanner.next();
        Double rating = scanner.nextDouble();
        String brandName = scanner.next();
        Beer beer = Beer.builder()
                .name(name)
                .voltage(rating)
                .brand(brandService.getByName(brandName))
                .build();
        beerService.save(beer);
    }

    private void deleteBrand() {
        String brandName = scanner.next();
        Brand brand = brandService.getByName(brandName);
        brandService.delete(brand);
    }

    private void deleteBeer() {
        String beerName = scanner.next();
        Beer beer = beerService.getByName(beerName);
        beerService.delete(beer);
    }
}

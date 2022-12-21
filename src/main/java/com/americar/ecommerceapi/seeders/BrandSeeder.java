package com.americar.ecommerceapi.seeders;

import com.americar.ecommerceapi.entity.Brand;
import com.americar.ecommerceapi.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class BrandSeeder implements CommandLineRunner {

    private final IBrandRepository brandRepository;;

    public BrandSeeder(IBrandRepository  brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear una lista de marcas
        List<Brand> brands = Arrays.asList(
                new Brand(UUID.randomUUID(), "Mazda"),
                new Brand(UUID.randomUUID(), "BMW"),
                new Brand(UUID.randomUUID(), "Toyota"),
                new Brand(UUID.randomUUID(), "Audii")
        );

        // Guardar las marcas en la base de datos
        brandRepository.saveAll(brands);
    }
}
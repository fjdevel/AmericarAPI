package com.americar.ecommerceapi.seeders;

import com.americar.ecommerceapi.entity.CodeShipping;
import com.americar.ecommerceapi.repository.ICodeShippingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Component
public class CodeShippingSeeder implements CommandLineRunner {

    private final ICodeShippingRepository codeShippingRepository;

    public CodeShippingSeeder(ICodeShippingRepository codeShippingRepository) {
        this.codeShippingRepository = codeShippingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear una lista de códigos de envío
        List<CodeShipping> codeShippings = Arrays.asList(
                new CodeShipping(UUID.randomUUID().toString(), "123456", "123 Main St", "New York", "John Doe", "10001"),
                new CodeShipping(UUID.randomUUID().toString(), "654321", "456 Main St", "Los Angeles", "Jane Doe", "90210"),
                new CodeShipping(UUID.randomUUID().toString(), "987654", "789 Main St", "Chicago", "Mike Smith", "60606")
        );

        // Guardar los códigos de envío en la base de datos
        codeShippingRepository.saveAll(codeShippings);
    }
}
package com.americar.ecommerceapi.seeders;

import com.americar.ecommerceapi.entity.Reservation;
import com.americar.ecommerceapi.entity.ReservedItem;
import com.americar.ecommerceapi.repository.IReservationsRepository;
import com.americar.ecommerceapi.repository.IReservedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class ReservationsSeeder implements CommandLineRunner {
    @Autowired
    private IReservationsRepository reservationRepository;

    @Autowired
    private IReservedItemRepository reservedItemRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crea una nueva reserva
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setCancelled("NO");
        reservation.setCustomer("Juan Pérez");
        reservation.setEndDate(new Date());
        reservation.setOrigin("Madrid");
        reservation.setRoute("Málaga");
        reservation.setSellerName("Pedro Martínez");
        reservation.setShippingId("123456");
        reservation.setStartDate(new Date().toString());
        reservation.setWarehouseId("1");

        // Crea un nuevo artículo reservado
        ReservedItem reservedItem = new ReservedItem();
        reservedItem.setId(UUID.randomUUID().toString());
        reservedItem.setBrand("Nike");
        reservedItem.setItem("Zapatillas de running");
        reservedItem.setStatus("PENDIENTE");
        reservedItemRepository.save(reservedItem);

        // Establece la relación entre la reserva y el artículo reservado
        reservedItem.setReservation(reservation);
        List<ReservedItem> items = new ArrayList<>();
        items.add(reservedItem);
        reservation.setReservedItems(items);

        // Guarda la reserva en la base de datos
        reservationRepository.save(reservation);
    }
}

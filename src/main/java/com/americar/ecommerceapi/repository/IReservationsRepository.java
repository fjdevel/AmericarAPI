package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IReservationsRepository extends JpaRepository<Reservation,String> {
    @Query("SELECT r FROM Reservation r LEFT JOIN r.reservedItems ri WHERE ri.id =:item AND ri.brand = :brand " +
            "AND r.cancelled = :cancelled AND r.customer = :customer AND r.endDate = :endDate " +
            "AND r.origin = :origin AND r.route = :route AND r.sellerName = :salesman " +
            "AND r.shippingId = :shippingId AND r.startDate = :startDate AND ri.status = :status " +
            "AND r.warehouseId = :warehouseId")
    List<Reservation> findByAttributes(@Param("item") String item,@Param("brand") String brand, @Param("cancelled") String cancelled,
                                       @Param("customer") String customer, @Param("endDate") Date endDate,
                                       @Param("origin") String origin, @Param("route") String route,
                                       @Param("salesman") String salesman, @Param("shippingId") String shippingId,
                                       @Param("startDate") Date startDate, @Param("status") String status,
                                       @Param("warehouseId") String warehouseId);
   }

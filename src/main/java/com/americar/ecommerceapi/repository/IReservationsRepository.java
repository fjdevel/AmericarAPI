package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IReservationsRepository extends JpaRepository<Reservation,Integer> {
    @Query("SELECT r FROM Reservation r LEFT JOIN r.reservedItems ri WHERE ri.id =:item OR ri.brand = :brand " +
            "OR r.cancelled = :cancelled OR r.customer = :customer OR r.endDate = :endDate " +
            "OR r.origin = :origin OR r.route = :route OR r.sellerName = :salesman " +
            "OR r.shippingId = :shippingId OR r.startDate = :startDate OR ri.status = :status " +
            "OR r.warehouseId = :warehouseId")
    List<Reservation> findByAttributes(@Param("item") String item,@Param("brand") String brand, @Param("cancelled") String cancelled,
                                       @Param("customer") String customer, @Param("endDate") Date endDate,
                                       @Param("origin") String origin, @Param("route") String route,
                                       @Param("salesman") String salesman, @Param("shippingId") String shippingId,
                                       @Param("startDate") String startDate, @Param("status") String status,
                                       @Param("warehouseId") String warehouseId);
   }

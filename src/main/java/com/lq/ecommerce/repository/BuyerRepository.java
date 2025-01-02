package com.lq.ecommerce.repository;

import com.lq.ecommerce.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Short> {
    Buyer findByUsername(String username);
    boolean existsByUsername(String username);

    @Modifying
    @Query(value = "INSERT INTO buyer (username, password, email, phone_number, address) " +
            "VALUES (:username, :password, :email, :phone, :address)", nativeQuery = true)
    void saveBuyer(@Param("username") String username, @Param("password") String password,
                   @Param("email") String email, @Param("phone") String phone,
                   @Param("address") String address);
}

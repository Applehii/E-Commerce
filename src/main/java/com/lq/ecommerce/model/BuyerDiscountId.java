package com.lq.ecommerce.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class BuyerDiscountId implements Serializable {
    private int buyer;
    private int discount;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyerDiscountId that)) return false;
        return Objects.equals(buyer, that.buyer) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer, discount);
    }
}
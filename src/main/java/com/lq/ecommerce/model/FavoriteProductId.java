package com.lq.ecommerce.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class FavoriteProductId implements Serializable {
    private int buyer;
    private int product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteProductId that)) return false;
        return Objects.equals(buyer, that.buyer) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer, product);
    }
}

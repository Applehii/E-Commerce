package com.lq.ecommerce.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class CartItemId implements Serializable {
    private int cart;
    private int product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItemId that)) return false;
        return Objects.equals(cart, that.cart) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart, product);
    }
}
package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "favorite_product")
@IdClass(FavoriteProductId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavouriteProduct {
    @Id
    @ManyToOne
    private Buyer buyer;

    @Id
    @ManyToOne
    private Product product;

    @Column(name = "added_at")
    private Timestamp addedAt;
}

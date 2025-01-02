package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;

@Entity
@Table(name = "shipping")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shipping {

    public enum ShippingStatus{
        PROCESSING,
        DELIVERED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shippingId;

    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(name = "shipping_method", length = 50)
    private String shippingMethod;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @ColumnDefault("'PROCESSING'")
    private ShippingStatus status;

    @Column(name = "shipped_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp shippedAt;

}


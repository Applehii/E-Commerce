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
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    public enum OrderStatus {
        Pending,
        Processing,
        OutForDelivering,
        Delivered,
        Cancelled,
        PaymentPending,
        PaymentCompleted,
        Return
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @ColumnDefault("'Pending'")
    private OrderStatus status;

    @Column(nullable = false)
    private Timestamp placedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Shipping shipping;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

}


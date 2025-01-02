package com.lq.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "discount_id", nullable = false)
    private String discount_id;

    @Column(name = "code", columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_percentage")
    private double percentage;

    @Column(name = "start_date", columnDefinition = "TIMESTAMPtz default current_timestamp")
    private Timestamp start_date;

    @Column(name = "end_date" ,columnDefinition = "TIMESTAMPtz")
    private Timestamp end_date;

    @OneToMany(mappedBy = "discount")
    private Set<BuyerDiscount> buyer_discount;


}

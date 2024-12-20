package com.lq.ecommerce.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierReponse {
    private int supplierId;
    private String name;
    private String address;
    private String contactInfo;
}

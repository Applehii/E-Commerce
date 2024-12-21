package com.lq.ecommerce.controller;

import com.lq.ecommerce.dto.response.APIResponse;
import com.lq.ecommerce.dto.response.SupplierReponse;
import com.lq.ecommerce.model.Supplier;
import com.lq.ecommerce.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Supplier")
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class Test {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public APIResponse<List<SupplierReponse>> getAllSuppliers() {
        List<SupplierReponse> suppliers = supplierService.getSupplier();
        APIResponse<List<SupplierReponse>> response = new APIResponse<>();
        response.setData(suppliers);
        return response;
    }
}

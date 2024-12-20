package com.lq.ecommerce.service;

import com.lq.ecommerce.dto.response.SupplierReponse;
import com.lq.ecommerce.mapper.SupplierMapper;
import com.lq.ecommerce.model.Supplier;
import com.lq.ecommerce.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<SupplierReponse> getSupplier() {
        List<SupplierReponse> suppliers = new ArrayList<>();
        SupplierReponse response = new SupplierReponse();
        for (Supplier supplier : supplierRepository.findAll()) {
            suppliers.add(supplierMapper.toSupplierReponse(supplier));
        }
        if (suppliers.isEmpty()) {
            System.out.println("No suppliers found");
        }
        return suppliers;
    }

}

package com.narvee.usit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvee.usit.model.Vendors;
import com.narvee.usit.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendors> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendors getVendorById(Long id) {
    
    		return vendorRepository.findById(id).get();
		
        
        
        
    }

    @Override
    public Vendors createVendor(Vendors vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendors updateVendor(Long id, Vendors vendor) {
        if (vendorRepository.existsById(id)) {
            vendor.setVmsid(id);
            return vendorRepository.save(vendor);
        }
        return null;
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

}
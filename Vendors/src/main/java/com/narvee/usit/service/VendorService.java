package com.narvee.usit.service;

import java.util.List;

import com.narvee.usit.model.Vendors;

public interface VendorService {

	public List<Vendors> getAllVendors();
    Vendors getVendorById(Long id);
    Vendors createVendor(Vendors vendor);
    Vendors updateVendor(Long id, Vendors vendor);
    void deleteVendor(Long id);
    

	

}


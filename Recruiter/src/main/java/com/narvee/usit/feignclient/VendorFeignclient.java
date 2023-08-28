package com.narvee.usit.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.narvee.usit.commons.Vendor;
import com.narvee.usit.response.RestApiResponse;

@FeignClient(value = "VENDOR-SERVICE",url = "http://localhost:9010")
public interface VendorFeignclient {
	
	@GetMapping( "/getbyid/{id}")
	public RestApiResponse getVendor(@PathVariable Long id);
	
	@PostMapping("/save")
	public Vendor saveVendor(Vendor vendor);
	
	@GetMapping("/all")
	public RestApiResponse allVendors();
	
	
	

}

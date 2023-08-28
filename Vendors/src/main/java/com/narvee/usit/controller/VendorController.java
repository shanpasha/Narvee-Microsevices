package com.narvee.usit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.model.Vendors;
import com.narvee.usit.response.RestApiResponse;
import com.narvee.usit.service.VendorService;

@RestController
public class VendorController {
	private final Logger logger = LoggerFactory.getLogger(VendorController.class);

	private final VendorService vendorService;

	@Autowired
	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RestApiResponse> createVendor(@RequestBody Vendors vendor) {
		logger.info("Received a request to create a new vendor.");
		return new ResponseEntity<>(new RestApiResponse("success", "vendorsaved", vendorService.createVendor(vendor)),
				HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<RestApiResponse>getAllVendors() {
		logger.info("VendorController.getAllVendors()");
		List<Vendors> allvendors = vendorService.getAllVendors();
		
		return new ResponseEntity<RestApiResponse>(new RestApiResponse("sucess", "vendors fetched sucessfully",allvendors), HttpStatus.OK);
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RestApiResponse> getbyid(@PathVariable long id) {
		Vendors vendor = vendorService.getVendorById(id);
		logger.info("vendor*********{}",vendor);
		return new ResponseEntity<RestApiResponse>(new RestApiResponse("sucess","vendor fetched sucessfully",vendor),HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<RestApiResponse> deleteVendor(@PathVariable Long id) {
		vendorService.deleteVendor(id);
		return new ResponseEntity<>(new RestApiResponse("Success", "Vendor deleted successfully", null), HttpStatus.OK);
	}
	
	
	

	
	
}

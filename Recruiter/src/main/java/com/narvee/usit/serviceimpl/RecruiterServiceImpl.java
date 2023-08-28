package com.narvee.usit.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.narvee.usit.commons.RecruiterResponse;
import com.narvee.usit.commons.Vendor;
import com.narvee.usit.feignclient.VendorFeignclient;
import com.narvee.usit.model.Recruiter;
import com.narvee.usit.repository.RecruiterRepository;
import com.narvee.usit.response.RestApiResponse;
import com.narvee.usit.service.RecruiterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Autowired
	private VendorFeignclient vendor;

	@Override
	public RecruiterResponse getAllRecruiters() {
		List<Recruiter> recruiters = recruiterRepository.findAll();
		RestApiResponse ven = vendor.allVendors();

		String j = OBjToJson(ven.getData());
		List<Vendor> vendors = listOfData(j);
//		Map<Vendor, Recruiter> allrecruiter = new HashMap<Vendor, Recruiter>();
		List<Object> unasign = new ArrayList<Object>();
		for (Vendor vendor : vendors) {

			for (Recruiter rec : recruiters) {
				if (vendor.getVmsid() == rec.getVmsid()) {
					unasign.add(vendor);
					unasign.add(rec);

				}
			}

		}

		return new RecruiterResponse(unasign);
	}

	@Override
	public RecruiterResponse getRecruiterById(Long id) {
		log.info("method is invoking");
		Recruiter recruiter = recruiterRepository.findById(id).get();
		RestApiResponse v = vendor.getVendor(recruiter.getVmsid());
		log.info("Vendor details..........{}", v);
		return new RecruiterResponse(recruiter, v.getData());
	}

	@Override
	public Recruiter saveRecruiter(Recruiter recruiter) {
		return recruiterRepository.save(recruiter);
	}

	@Override
	public void deleteRecruiter(Long id) {
		recruiterRepository.deleteById(id);
	}

	@Override
	public RecruiterResponse findByRecruiter(String recruiter) {
		Recruiter rec = recruiterRepository.findByRecruiter(recruiter);
		RestApiResponse ven = vendor.getVendor(rec.getVmsid());
		return new RecruiterResponse(rec, ven.getData());
	}

	// here converting object to json
	public String OBjToJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(obj);
			log.info("*****************{}", jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;

	}

	public List<Vendor> listOfData(String jSonData) {

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		objectMapper.registerModule(new JavaTimeModule());

		List<Vendor> list = new ArrayList<>();
		try {
			JsonNode jsonArray = objectMapper.readTree(jSonData);
			for (JsonNode jsonNode : jsonArray) {
				Vendor object = objectMapper.treeToValue(jsonNode, Vendor.class);
				list.add(object);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return list;

	}

}

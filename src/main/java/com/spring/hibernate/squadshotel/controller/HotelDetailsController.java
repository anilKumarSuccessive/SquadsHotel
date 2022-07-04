package com.spring.hibernate.squadshotel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// List of hotels
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HotelDetailsController {

	Logger logger = LoggerFactory.getLogger(HotelDetailsController.class);
	@Value("${api.key}")
	private String apiKey;

	@SuppressWarnings("unchecked")
	@GetMapping("/hotels")
	public ModelAndView getHotels() throws JsonMappingException, JsonProcessingException {
		String startDate="2022-07-05";
		String endDate="2022-07-06";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq");
		HttpEntity<Object> entity = new HttpEntity<>(headers);
	
		String url = "https://sandbox.impala.travel/v1/hotels/?start="+startDate+"&end="+endDate;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> rateResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		String response = rateResponse.getBody();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map = mapper.readValue(rateResponse.getBody(), new TypeReference<Map<String, Object>>() {
		});
		ArrayList<Map<String, Object>> arr = new ArrayList<>();

		for (int i = 0; i < map.size(); i++) {
			arr.addAll((Collection<? extends Map<String, Object>>) map.get("data"));
			//System.out.println(arr);
		}
		ModelAndView mr = new ModelAndView("rooms.html");
		mr.addObject("arr1", arr);
		return mr;

	}

}

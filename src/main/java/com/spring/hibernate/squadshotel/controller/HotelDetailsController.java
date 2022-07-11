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
		String startDate = "2022-07-20";
		String endDate = "2022-07-24";

		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq");
		HttpEntity<Object> entity = new HttpEntity<>(headers);

		String url = "https://sandbox.impala.travel/v1/hotels/?start=" + startDate + "&end=" + endDate;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> rateResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map = mapper.readValue(rateResponse.getBody(), new TypeReference<Map<String, Object>>() {
		});
		ArrayList<Map<String, Object>> arr = new ArrayList<>();
		ArrayList<Map<String, Object>> arrRoomtypes = new ArrayList<>();
		ArrayList<Map<String, Object>> arrrates = new ArrayList<>();
			//System.out.println(map.size());
		for (int i = 0; i < map.size() - 1; i++) {
			arr.addAll((Collection<? extends Map<String, Object>>) map.get("data"));
		}
		for (int j = 0; j < arr.size() - 1; j++) {
			arrRoomtypes.addAll((Collection<? extends Map<String, Object>>) arr.get(j).get("roomTypes"));
		}
		for (int k = 0; k < arrRoomtypes.size() - 1; k++) {
			arrrates.addAll((Collection<? extends Map<String, Object>>) arrRoomtypes.get(k).get("rates"));

		}
		LinkedHashMap<String, LinkedHashMap<String, Integer>> retailRates = new LinkedHashMap<>();
		for (int l = 0; l < arrrates.size() - 1; l++)
			retailRates.putAll(
					(Map<? extends String, ? extends LinkedHashMap<String, Integer>>) arrrates.get(l).get("retailRate"));

		LinkedHashMap<String, Integer> total = retailRates.get("total");
		
		ModelAndView mr = new ModelAndView("rooms.html");
		mr.addObject("arr1", arr);
		mr.addObject("total1", total);
		return mr;
		
		
		

	}

}

package com.spring.hibernate.squadshotel.controller;

// find hotel by Hotel id
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RoomDetailsController {

	Logger logger = LoggerFactory.getLogger(HotelDetailsController.class);
	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<String> getHotels(@PathVariable("hotelId") String hotelId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq");
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		String url = "https://sandbox.impala.travel/v1/hotels/" + hotelId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return res;
	}
}

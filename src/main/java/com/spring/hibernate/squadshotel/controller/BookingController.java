package com.spring.hibernate.squadshotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class BookingController {
	Logger logger = LoggerFactory.getLogger(HotelDetailsController.class);
	@Value("${api.key}")
	private String apiKey;

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
		return converter;
	}

	@RequestMapping("/hotels/booking")
	public String getBooking() throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://sandbox.impala.travel/v1/bookings")
		  .header("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq")
		  .header("Content-Type", "application/json")
		  .body("{\n  \"start\": \"2022-06-29\",\n  \"end\": \"2022-06-30\",\n  \"bookingContact\": {\n    \"firstName\": \"Anil\",\n    \"lastName\": \"Kumar\",\n    \"email\": \"anil.kumar@it.com\"\n  },\n  \"rooms\": [\n    {\n      \"rateId\": \"e670ee07a069ba4ab8bb5fef2a84d918:0aed847c03cb0778c874040cc0f6c8e5837c343905581080896dc27a872327add64ea449fcc41b9ad15791a0a7fc866371ce2a7949a922f25feb25b046215c7c\",\n      \"adults\": 1\n    }\n  ]\n}")
		  .asString();

		return response.getBody();
	}
	
	@GetMapping("/hotels/bookings")
	public String getAllBooking() throws UnirestException {
	Unirest.setTimeouts(0, 0);
	HttpResponse<String> response = Unirest.get("https://sandbox.impala.travel/v1/bookings")
	  .header("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq")
	  .asString();
	return response.getBody();
	}
	
	@GetMapping("/hotels/booking/{bookingId}")
	public ResponseEntity<String> getParticularBooking(@PathVariable("bookingId") String bookingId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq");
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		String url = "https://sandbox.impala.travel/v1\n"
				+ "/bookings/" + bookingId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return res;
	}
	
	@RequestMapping("/hotels/booking/update")
	public HttpResponse<String> updateBooking() throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.put("https://sandbox.impala.travel/v1/bookings/SANDBOX-199A-00544481")
		  .header("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq")
		  .header("Content-Type", "application/json")
		  .body("{\n  \"start\": \"2022-07-02\",\n  \"end\": \"2022-07-03\",\n  \"bookingContact\": {\n    \"firstName\": \"ranveer\",\n    \"lastName\": \"Kumara\",\n    \"email\": \"ranveer.rai@it.com\"\n  },\n  \"rooms\": [\n    {\n      \"rateId\": \"bacb90220356287914ae86c106d4c737:ef009aed1e3e4c5c0965ad187cd9d1f8c34fe969e588cf615d80d64b5cc03f65c27966a7921376ea6111474edb3f4c35533cc4b814be75e543fae5f9ae94cc7b\",\n      \"adults\": 1\n    }\n  ],\n  \"updateBookingVersionAtTimestamp\": \"2022-06-30T06:10:35.270Z\"\n}")
		  .asString();

		return response;

	}
	
}
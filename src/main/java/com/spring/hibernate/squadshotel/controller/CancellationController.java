package com.spring.hibernate.squadshotel.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class CancellationController {
	@RequestMapping("/hotels/booking/{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable("bookingId") String cancelId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq");
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		String url = "https://sandbox.impala.travel/v1\n"
				+ "/bookings/" + cancelId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
		return res;
	}
}

/*
 * package com.spring.hibernate.squadshotel.controller;
 * 
 * import java.util.ArrayList; import java.util.Collection; import
 * java.util.HashMap; import java.util.Map;
 * 
 * // find hotel by Hotel id import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestTemplate; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.core.type.TypeReference; import
 * com.fasterxml.jackson.databind.JsonMappingException; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @RestController public class RoomDetailsController {
 * 
 * Logger logger = LoggerFactory.getLogger(HotelDetailsController.class);
 * 
 * @Value("${api.key}") private String apiKey;
 * 
 * @GetMapping("/hotels/{hotelId}") public ModelAndView
 * getHotels(@PathVariable("hotelId") String hotelId) throws
 * JsonMappingException, JsonProcessingException { HttpHeaders headers = new
 * HttpHeaders(); headers.add("x-api-key",
 * "sandb_o0yTj57YBrlYWB3FSabE7GgXMnpCmIpDOzlhGQLq"); HttpEntity<Object> entity
 * = new HttpEntity<>(headers); String url =
 * "https://sandbox.impala.travel/v1/hotels/" + hotelId; RestTemplate
 * restTemplate = new RestTemplate(); ResponseEntity<String> res =
 * restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
 * 
 * ObjectMapper mapper = new ObjectMapper(); Map<String, Object> map = new
 * HashMap<>(); map = mapper.readValue(res.getBody(), new
 * TypeReference<Map<String, Object>>() { }); ArrayList<Map<String, Object>>
 * pdpArr = new ArrayList<>(); pdpArr.add(map);
 * 
 * ModelAndView roomD=new ModelAndView("roomDetails.html");
 * roomD.addObject("pdpArr1", pdpArr); return roomD; } }
 */
package com.target.metrotransit.consumer.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.metrotransit.consumer.model.Departure;

import static com.target.metrotransit.consumer.config.RestClientConfig.*;

@Service
public class DepartureService {
	
	private static final Logger log = LoggerFactory.getLogger(DepartureService.class);
	
	@Autowired
    RestTemplate restTemplate;
	
	public List<Departure> findDepartures(String routeId, String directionId, String stopId) {
		String departureApi = routeId + SLASH + directionId + SLASH + stopId + JSON_FORMAT;
		Departure[] departure = restTemplate.getForObject(departureApi, Departure[].class);
		log.debug("Total Departures Count : " + departure.length);
		return Arrays.asList(departure);
	}
	
}

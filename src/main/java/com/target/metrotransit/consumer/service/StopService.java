package com.target.metrotransit.consumer.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.metrotransit.consumer.model.Stop;

import static com.target.metrotransit.consumer.config.RestClientConfig.*;

@Service
public class StopService {
	
	private static final Logger log = LoggerFactory.getLogger(StopService.class);
	
	private static final String API_STOP_SERVICE = Stop.STOPS + SLASH;
	
	@Autowired
    RestTemplate restTemplate;
	
	public List<Stop> findStops(String routeId, String directionId) {
		String stopApi = API_STOP_SERVICE + routeId + SLASH + directionId + JSON_FORMAT;
		Stop[] stops = restTemplate.getForObject(stopApi, Stop[].class);
		log.debug("Total Stops Count : " + stops.length);
		return Arrays.asList(stops);
	}
	
}

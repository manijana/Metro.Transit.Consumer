package com.target.metrotransit.consumer.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.metrotransit.consumer.model.Direction;
import com.target.metrotransit.consumer.util.Codec;

import static com.target.metrotransit.consumer.config.RestClientConfig.*;

@Service
public class DirectionService {
	
	private static final Logger log = LoggerFactory.getLogger(DirectionService.class);
	
	private static final String API_DIRECTION_SERVICE = Direction.DIRECTIONS + SLASH;
	
	@Autowired
    RestTemplate restTemplate;
	
	public List<Direction> findDirections(String routeId) {
		String directionApi = API_DIRECTION_SERVICE + routeId + JSON_FORMAT;
		Direction[] directions = restTemplate.getForObject(directionApi, Direction[].class);
		log.debug("Available Directions : " + new Codec<>().toJson(directions));
		return Arrays.asList(directions);
	}
	
}

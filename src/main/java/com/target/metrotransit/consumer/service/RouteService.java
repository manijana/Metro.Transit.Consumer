package com.target.metrotransit.consumer.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.metrotransit.consumer.model.Route;

import static com.target.metrotransit.consumer.config.RestClientConfig.*;

@Service
public class RouteService {
	
	private static final Logger log = LoggerFactory.getLogger(RouteService.class);
	
	private Map<String, Route> mapRoutes = null;
	
	private static final String API_ROUTE_SERVICE = Route.ROUTES + JSON_FORMAT;
	
	@Autowired
    RestTemplate restTemplate;
	
	@PostConstruct
    public void loadRoutes() {
    	mapRoutes = new HashMap<>();
        Route[] routes = restTemplate.getForObject(API_ROUTE_SERVICE, Route[].class);
        if (routes != null) {
        	/*
            List<Route> rList = new ArrayList<>(Arrays.asList(routes));
            rList.forEach((Route route) -> {
            	mapRoutes.put(route.getDescription(), route);
            });
            */
        	log.debug("Total Routes Count : " + routes.length);
            for (Route route : routes) {
            	mapRoutes.put(route.getDescription(), route);
			}
        }
    }
	
	@Bean
    public Map<String, Route> getRoutes() {
    	return this.mapRoutes;
    }
}
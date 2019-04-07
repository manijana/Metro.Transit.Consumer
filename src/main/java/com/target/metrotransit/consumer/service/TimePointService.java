package com.target.metrotransit.consumer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.metrotransit.consumer.model.Departure;
import com.target.metrotransit.consumer.model.Route;
import com.target.metrotransit.consumer.model.Stop;
import com.target.metrotransit.consumer.util.Codec;

@Service
public class TimePointService {

	private static final Logger log = LoggerFactory.getLogger(TimePointService.class);

	@Autowired
	RouteService routeService;

	/*
	@Autowired
	DirectionService directionService;
	*/

	@Autowired
	StopService stopService;

	@Autowired
	DepartureService departureService;

	public String findNextBus(String routeName, String busStop, String directionName) throws Exception {
		final Departure departureNextBus = new Departure();
		System.out.println("Routes : " + routeService.getRoutes());
		Route route = routeService.getRoutes().get(routeName);
		log.debug("Route Details : " + new Codec<>().toJson(route));
		if (route != null) {
			log.debug("RouteId : " + route.getRouteId() + " for given Route : " + routeName);
			// List<Direction> listDirections =
			// directionService.findDirections(route.getRouteId());
			String directionId = Stop.Direction.valueOf(directionName).getDirectionId();
			log.debug("DirectionId : " + directionId + " for given Direction : " + directionName);
			List<Stop> listStops = stopService.findStops(route.getRouteId(), directionId);
			if (!listStops.isEmpty()) {
				listStops.forEach((Stop stop) -> {
					if (stop.getStopName().equalsIgnoreCase(busStop)) {
						log.debug("StopId : " + stop.getStopId() + " for given BusStop : " + busStop);
						List<Departure> listDepartures = departureService.findDepartures(route.getRouteId(), directionId, stop.getStopId());
						if (!listDepartures.isEmpty()) {
							listDepartures.forEach((Departure departure) -> {
								if (departure.isActual())
									departureNextBus.setDepartureText(departure.getDepartureText());
							});
						}
					}
				});
			}
		}
		log.debug("NextBus Departure Time : " + departureNextBus.getDepartureText());
		System.out.println("NextBus Departure Time : " + departureNextBus.getDepartureText());
		return departureNextBus.getDepartureText();
	}
	
	public String refreshRoutes() throws Exception {
		routeService.loadRoutes();
		if(routeService.getRoutes().size() > 0)
			return "Successfully loaded Routes";
		else
			return "Unable to load Routes";
	}

}

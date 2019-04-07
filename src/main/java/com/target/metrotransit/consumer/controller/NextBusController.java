package com.target.metrotransit.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.metrotransit.consumer.model.PostBody;
import com.target.metrotransit.consumer.service.TimePointService;

import static com.target.metrotransit.consumer.config.RestClientConfig.*;

@RestController
@RequestMapping(SLASH + NextBusController.API_ROOT)
public class NextBusController {
	
	private static final Logger log = LoggerFactory.getLogger(NextBusController.class);
	
	public static final String API_ROOT = "api";
	public static final String nextBusPath = "nextbus";
	
	public static final String GET_METHOD = "get", POST_METHOD = "post";
	
	private static final String Source = "source";
    private static final String Destination = "destination";
    private static final String Direction = "direction";
    
    public static final String NextBusApiGetPath = SLASH  + nextBusPath + SLASH 
	    											+ GET_METHOD + SLASH 
	    											+ OPEN_BRACE + Source + CLOSE_BRACE + SLASH 
	    											+ OPEN_BRACE + Destination + CLOSE_BRACE + SLASH 
	    											+ OPEN_BRACE + Direction + CLOSE_BRACE;
    
    public static final String NextBusApiPostPath = SLASH  + nextBusPath;
    
    @Autowired
    TimePointService timePointService;
    
    @GetMapping(NextBusApiGetPath)
    public String findNextBus_Using_GetMapping(@PathVariable String source, @PathVariable String destination, 
    		@PathVariable String direction) throws Exception {
    	log.debug("source : " + source + "\t destination : " + destination + "\t direction : " + direction);
    	System.out.println("source : " + source + "\t destination : " + destination + "\t direction : " + direction);
        return timePointService.findNextBus(source, destination, direction);
    }
    
    @RequestMapping(value = "/nextbus/RequestMappingGET/{source}/{destination}/{direction}", method = RequestMethod.GET)
    public String findNextBus_Using_RequestMapping(@PathVariable String source, @PathVariable String destination, 
    		@PathVariable String direction) throws Exception {
    	log.debug("source : " + source + "\t destination : " + destination + "\t direction : " + direction);
    	System.out.println("source : " + source + "\t destination : " + destination + "\t direction : " + direction);
        return timePointService.findNextBus(source, destination, direction);
    }
    
    @PostMapping(path = NextBusApiPostPath + SLASH + "PostMapping", consumes = "application/json")
    public String findNextBus_Using_PostMapping(@RequestBody PostBody bodyRequest) throws Exception {
    	log.debug("source : " + bodyRequest.getSource() + "\t destination : " + bodyRequest.getDestination() 
			+ "\t direction : " + bodyRequest.getDirection());
		System.out.println("source : " + bodyRequest.getSource() + "\t destination : " + bodyRequest.getDestination() 
			+ "\t direction : " + bodyRequest.getDirection());
	    return timePointService.findNextBus(bodyRequest.getSource(), bodyRequest.getDestination(), bodyRequest.getDirection());
	}
	    
    @RequestMapping(path = NextBusApiPostPath + SLASH + "RequestMappingPOST", consumes = "application/json")
    public String findNextBus_Using_RequestMapping(@RequestBody PostBody bodyRequest) throws Exception {
    	log.debug("source : " + bodyRequest.getSource() + "\t destination : " + bodyRequest.getDestination() 
    		+ "\t direction : " + bodyRequest.getDirection());
    	System.out.println("source : " + bodyRequest.getSource() + "\t destination : " + bodyRequest.getDestination() 
    		+ "\t direction : " + bodyRequest.getDirection());
        return timePointService.findNextBus(bodyRequest.getSource(), bodyRequest.getDestination(), bodyRequest.getDirection());
    }
    
    @GetMapping("/RefreshRoutes")
    public String refreshRoutes() throws Exception {
    	return timePointService.refreshRoutes();
    }
}
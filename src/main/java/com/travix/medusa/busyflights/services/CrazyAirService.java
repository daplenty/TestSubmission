/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.Exception.RestException;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.mapper.CrazyAirMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author temitokut
 */
@Component
public class CrazyAirService implements Supplier {

    private final RestCaller<CrazyAirRequest, CrazyAirResponse> restCaller;
    private final CrazyAirMapper crazyAirMapper = new CrazyAirMapper();
    
    @Autowired
    public CrazyAirService(RestTemplate restTemplate, Environment environment) {
        this.restCaller = new RestCaller<>(environment.getProperty("supplier.crazyair.endpoint"),restTemplate);
    }
    
    @Override
    public List<BusyFlightsResponse> searchForFlight(BusyFlightsRequest busyFlightsRequest) {
                
         List<BusyFlightsResponse> busyFlightResponses = new ArrayList<>();
         
         try {
            List<CrazyAirResponse> crazyAirResponses = restCaller.postRequest(crazyAirMapper.mapRequest(busyFlightsRequest),
                            new ParameterizedTypeReference<List<CrazyAirResponse>>() {
                            }
                    );
               
            
            
            
            for(CrazyAirResponse crazyairresponse : crazyAirResponses){
            
             BusyFlightsResponse result = crazyAirMapper.mapResponse(crazyairresponse);
                
            }
            crazyAirResponses.forEach(crazyAirResponse -> busyFlightResponses.add( crazyAirMapper.mapResponse(crazyAirResponse)));
                     
        } catch (RestException ex) {
           
        }
        return busyFlightResponses;
    
    }

  
}

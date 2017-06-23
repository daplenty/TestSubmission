/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.services;


import com.travix.medusa.busyflights.Exception.RestException;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.mapper.ToughjetMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author temitokut
 */
public class ToughJetService implements Supplier  {

    
    private final RestCaller<ToughJetRequest, ToughJetResponse> restCaller;
     private final ToughjetMapper toughjetMapper = new ToughjetMapper();
    
    @Autowired
    public ToughJetService(RestTemplate restTemplate, Environment environment) {
        this.restCaller = new RestCaller<>(environment.getProperty("supplier.toughjet.endpoint"),restTemplate);
    }
    
    
   @Override
    public List<BusyFlightsResponse> searchForFlight(BusyFlightsRequest busyFlightsRequest) {
        
      List<BusyFlightsResponse> busyFlightResponses = new ArrayList<>();
      
        try {
            List<ToughJetResponse> toughjetResponses = restCaller.postRequest(toughjetMapper.mapRequest(busyFlightsRequest),
                            new ParameterizedTypeReference<List<ToughJetResponse>>() {
                            }
                    );
               
            toughjetResponses.forEach(toughjetResponse -> busyFlightResponses.add( toughjetMapper.mapResponse(toughjetResponse)));
                     
        } catch (RestException ex) {
           
        }
        return busyFlightResponses;
    
    }
    
}

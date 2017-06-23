/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author temitokut
 */

@Service
public class BusyFlightsService implements HostGateway{

    private List<Supplier> supplierServices;
    
    @Autowired
    public BusyFlightsService(List<Supplier> supplierServices) {
        this.supplierServices = supplierServices;
    }

    
    @Override
    public List<BusyFlightsResponse> searchForFlight(BusyFlightsRequest busyFlightsRequest) {
        
        List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();
        supplierServices.stream().map((provider) -> provider.searchForFlight(busyFlightsRequest)).forEach((results) -> {
            busyFlightsResponses.addAll(results);
        });
        
         busyFlightsResponses.sort(Comparator.comparing(BusyFlightsResponse::getFare));
               
        return busyFlightsResponses;
     
    }
    
}

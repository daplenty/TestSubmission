/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import java.util.List;

/**
 *
 * @author temitokut
 */
public interface Supplier { 
       
     List<BusyFlightsResponse> searchForFlight(BusyFlightsRequest busyFlightsRequest);
     
}

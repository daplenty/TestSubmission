/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.mapper;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

/**
 *
 * @author temitokut
 */
public interface SupplierMapper <T, S>{
    
    public T mapRequest(BusyFlightsRequest busyFlightsRequest);
	
    public BusyFlightsResponse mapResponse(S response);
    

}

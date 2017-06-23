/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.mapper;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author temitokut
 */
public class CrazyAirMapper  implements SupplierMapper<CrazyAirRequest, CrazyAirResponse> {

    @Override
    public CrazyAirRequest mapRequest(BusyFlightsRequest busyFlightsRequest) {
        
                CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
		crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
		crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
		crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
		crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
		return crazyAirRequest;
   }

   

    @Override
    public BusyFlightsResponse mapResponse(CrazyAirResponse response) {
        
             BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		
        busyFlightsResponse.setAirline(response.getAirline());
		
        busyFlightsResponse.setSupplier("CrazyAir");
		
		Double fare = Math.round(response.getPrice() * 100.0) / 100.0;
		busyFlightsResponse.setFare(fare);
		
		busyFlightsResponse.setDepartureAirportCode(response.getDepartureAirportCode());
		busyFlightsResponse.setDestinationAirportCode(response.getDestinationAirportCode());
		
		busyFlightsResponse.setDepartureDate(LocalDateTime.parse(response.getDepartureDate()));
		busyFlightsResponse.setArrivalDate(LocalDateTime.parse(response.getArrivalDate()));
        
		return busyFlightsResponse;
    }
    
   
         
	
}

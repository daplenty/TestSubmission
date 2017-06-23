/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.mapper;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 *
 * @author temitokut
 */
public class ToughjetMapper implements SupplierMapper<ToughJetRequest, ToughJetResponse>  {

    @Override
    public ToughJetRequest mapRequest(BusyFlightsRequest busyFlightsRequest) {
        
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
        toughJetRequest.setTo(busyFlightsRequest.getDestination());
        toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
       
        return toughJetRequest;
        
   }

    @Override
    public BusyFlightsResponse  mapResponse(ToughJetResponse response) {
         BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		
        busyFlightsResponse.setAirline(response.getCarrier());
		
        busyFlightsResponse.setSupplier("ToughJet");
         
                Double priceOnTax = response.getBasePrice() + response.getTax();		
		Double priceNetDiscount = priceOnTax - (response.getDiscount() / 100 ) * priceOnTax;		
		Double fare =  Math.round(priceNetDiscount * 100.0) / 100.0;
		
		busyFlightsResponse.setFare(fare);
		
                
                 Instant outBoundInstant = Instant.parse(response.getOutboundDateTime());
                 LocalDateTime outboundLocalDateTime = LocalDateTime.ofInstant(outBoundInstant, ZoneOffset.UTC);  
		 busyFlightsResponse.setDepartureDate(outboundLocalDateTime);
                 
                
                 Instant inBoundInstant = Instant.parse(response.getInboundDateTime());
                 LocalDateTime inboundLocalDateTime = LocalDateTime.ofInstant(inBoundInstant, ZoneOffset.UTC);  
		 busyFlightsResponse.setDepartureDate(inboundLocalDateTime);
                
        
		return busyFlightsResponse;
   }
    
   
    
         
}

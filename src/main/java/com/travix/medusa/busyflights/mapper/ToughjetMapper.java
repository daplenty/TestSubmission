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
import java.time.format.DateTimeFormatter;

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
                
                
                busyFlightsResponse.setDepartureAirportCode(response.getDepartureAirportName());
                busyFlightsResponse.setDestinationAirportCode(response.getArrivalAirportName());
		
                
                 Instant outBoundInstant = Instant.parse(response.getOutboundDateTime());
                 LocalDateTime outboundLocalDateTime = LocalDateTime.ofInstant(outBoundInstant, ZoneOffset.UTC);  
                 String outboundLocalDateTimeStr = outboundLocalDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
                 
		 busyFlightsResponse.setDepartureDate(outboundLocalDateTimeStr);
                 
                
                 Instant inBoundInstant = Instant.parse(response.getInboundDateTime());
                 LocalDateTime inboundLocalDateTime = LocalDateTime.ofInstant(inBoundInstant, ZoneOffset.UTC); 
                 String inboundLocalDateTimeStr = inboundLocalDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
                 
		 busyFlightsResponse.setDepartureDate(inboundLocalDateTimeStr);
                
        
		return busyFlightsResponse;
   }
    
   
    
         
}

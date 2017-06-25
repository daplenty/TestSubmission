package com.travix.medusa.busyflights.domain.busyflights;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import java.util.Date;

public class BusyFlightsResponse {
    
       private String airline;
       private String supplier;
       private Double fare;
	private String departureAirportCode;
	private String destinationAirportCode;       
	private String departureDate;
	private String arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

   
        
        
    
}

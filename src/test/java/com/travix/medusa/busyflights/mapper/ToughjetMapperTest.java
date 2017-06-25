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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author temitokut
 */
public class ToughjetMapperTest {
    
    public ToughjetMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mapRequest method, of class ToughjetMapper.
     */
    @Test
    public void testMapRequest() {
        System.out.println("mapRequest");
        BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
        
       busyFlightsRequest.setOrigin("LOS");
       busyFlightsRequest.setDestination("ABJ");
       busyFlightsRequest.setNumberOfPassengers(4);
       busyFlightsRequest.setDepartureDate("12-03-2016");
       busyFlightsRequest.setReturnDate("12-03-2016");
       
       
        ToughjetMapper instance = new ToughjetMapper();
   
        ToughJetRequest result = instance.mapRequest(busyFlightsRequest);
        assertEquals(busyFlightsRequest.getNumberOfPassengers(), result.getNumberOfAdults());
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of mapResponse method, of class ToughjetMapper.
     */
    @Test
    public void testMapResponse() {
        System.out.println("mapResponse");
        ToughJetResponse toughJetResponse = new ToughJetResponse();
         toughJetResponse.setCarrier("ARIK");
        toughJetResponse.setArrivalAirportName("LHR");
        toughJetResponse.setDepartureAirportName("AMS");
        toughJetResponse.setBasePrice(211.19);
        toughJetResponse.setDiscount(10.00);
        toughJetResponse.setTax(7);
        toughJetResponse.setInboundDateTime("2017-06-23T21:23:56.870Z");
        toughJetResponse.setOutboundDateTime("2017-06-23T21:23:56.870Z");
        ToughjetMapper instance = new ToughjetMapper();
       
        BusyFlightsResponse result = instance.mapResponse(toughJetResponse);
        assertEquals(toughJetResponse.getDepartureAirportName(), result.getDepartureAirportCode());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}

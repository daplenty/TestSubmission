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
public class CrazyAirMapperTest {
    
    public CrazyAirMapperTest() {
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
     * Test of mapRequest method, of class CrazyAirMapper.
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
       
        CrazyAirMapper instance = new CrazyAirMapper();
 
        CrazyAirRequest result = instance.mapRequest(busyFlightsRequest);
        assertEquals(busyFlightsRequest.getNumberOfPassengers(), result.getPassengerCount());
       
    }

    /**
     * Test of mapResponse method, of class CrazyAirMapper.
     */
    @Test
    public void testMapResponse() {
        System.out.println("mapResponse");
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline("ARIC");
        crazyAirResponse.setCabinclass("B");
        crazyAirResponse.setDepartureAirportCode("LHR");
        crazyAirResponse.setDestinationAirportCode("LHR");
        crazyAirResponse.setDepartureDate("2017-06-23T10:15:30");
        crazyAirResponse.setArrivalDate("2017-06-23T10:15:30");
        crazyAirResponse.setPrice(20.11);
        CrazyAirMapper instance = new CrazyAirMapper();
      
        BusyFlightsResponse result = instance.mapResponse(crazyAirResponse);
        assertEquals(crazyAirResponse.getDestinationAirportCode(), result.getDestinationAirportCode());
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}

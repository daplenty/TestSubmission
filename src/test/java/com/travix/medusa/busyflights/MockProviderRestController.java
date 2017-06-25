/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author temitokut
 */

@TestComponent
@RestController
public class MockProviderRestController {
    
     @RequestMapping(value = "/toughjet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ToughJetResponse>> toughJet(@RequestBody ToughJetRequest request) {
        List<ToughJetResponse> jetResponses = new ArrayList<>();
       
        
        ToughJetResponse toughJetResponse= new ToughJetResponse();
        toughJetResponse.setCarrier("ARIK");
        toughJetResponse.setArrivalAirportName("LHR");
        toughJetResponse.setDepartureAirportName("AMS");
        toughJetResponse.setBasePrice(211.19);
        toughJetResponse.setDiscount(10.00);
        toughJetResponse.setTax(7);
        toughJetResponse.setInboundDateTime("2017-06-23T21:23:56.870Z");
        toughJetResponse.setOutboundDateTime("2017-06-23T21:23:56.870Z");
        jetResponses.add(toughJetResponse);
        
        return ResponseEntity.ok(jetResponses);
    }


    @RequestMapping(value = "/crazyair", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CrazyAirResponse>> crazyAir(@RequestBody CrazyAirRequest request) {
        List<CrazyAirResponse> responses = new ArrayList<>();
        
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline("ARIC");
        crazyAirResponse.setCabinclass("B");
        crazyAirResponse.setDepartureAirportCode("LHR");
        crazyAirResponse.setDestinationAirportCode("LHR");
        crazyAirResponse.setDepartureDate("2017-06-23T10:15:30");
        crazyAirResponse.setArrivalDate("2017-06-23T10:15:30");
        crazyAirResponse.setPrice(20.11);
        
        responses.add(crazyAirResponse);
        return ResponseEntity.ok(responses);
    }
}

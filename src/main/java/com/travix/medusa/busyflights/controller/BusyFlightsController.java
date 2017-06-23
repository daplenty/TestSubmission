/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.BusyFlightsService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/busyflights")
public class BusyFlightsController extends AbstractControllerHandler {
    
    @Autowired
    private BusyFlightsService busyFlightsService;
    
    
     @RequestMapping(value = "/findall", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        
    public ResponseEntity<List<BusyFlightsResponse>> searchFlights(@RequestBody @Valid BusyFlightsRequest busyFlightsRequest) {
        return ResponseEntity.ok(busyFlightsService.searchForFlight(busyFlightsRequest));
    }

    
    
}

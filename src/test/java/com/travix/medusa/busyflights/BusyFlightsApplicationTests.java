package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.HostGateway;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:test.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusyFlightsApplicationTests {
    
      /**
     * A mocked DocumentController
     */

  
    
    @Autowired
    private HostGateway hostService;

    
    /**
     * Setup each test method. Initialize Mockito mock and spy objects. Scan for
     * Mockito annotations.
     */
   
    
      @Test
    public void mockServiceSuppliers() {
        
       BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
       
       busyFlightsRequest.setOrigin("INR");
       busyFlightsRequest.setDestination("NGN");
       busyFlightsRequest.setNumberOfPassengers(4);
       busyFlightsRequest.setDepartureDate("12-03-2016");
       busyFlightsRequest.setReturnDate("12-03-2016");
        
        List<BusyFlightsResponse> searchResults = hostService.searchForFlight(busyFlightsRequest);
        assertEquals(2, searchResults.size());
        assertEquals(searchResults.get(0).getSupplier(), "CrazyAir");
        assertEquals(searchResults.get(1).getSupplier(), "ToughJet");
    }

}

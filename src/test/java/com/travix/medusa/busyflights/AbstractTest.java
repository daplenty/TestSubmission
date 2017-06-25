package com.travix.medusa.busyflights;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * The AbstractTest class is the parent of My JUnit test classes. This class
 * configures the test ApplicationContext and test runner environment.
 * 
 * @author Temitope Kuti
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BusyFlightsApplication.class)
public abstract class AbstractTest {

    /**
     * The Logger instance for all classes in the unit test framework.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}

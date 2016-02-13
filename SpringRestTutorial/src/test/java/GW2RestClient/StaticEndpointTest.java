package GW2RestClient;

import org.junit.Test;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class StaticEndpointTest {

    private final static Logger log = LoggerFactory.getLogger(StaticEndpointTest.class);

    @Test
    public void testIsReachable() throws Exception {
        StaticEndpoint staticEndpoint = new StaticEndpoint("http://www.google.com");

        assertTrue(staticEndpoint.isReachable());
    }
}
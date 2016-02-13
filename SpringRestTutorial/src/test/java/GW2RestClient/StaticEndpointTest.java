package GW2RestClient;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticEndpointTest {

    @Test
    public void testIsReachable() throws Exception {
        assertTrue(new StaticEndpoint().isReachable());
    }
}
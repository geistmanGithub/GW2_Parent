package GW2RestClient;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by geistman on 13.02.16.
 */
public class StaticEndpintTest {

    @Test
    public void testIsReachable() throws Exception {
        assertTrue(new StaticEndpint().isReachable());
    }
}
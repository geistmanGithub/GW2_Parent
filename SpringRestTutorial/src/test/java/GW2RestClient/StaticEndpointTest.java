package GW2RestClient;

import org.junit.Test;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Boolean.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StaticEndpointTest {

    private final static Logger log = LoggerFactory.getLogger(StaticEndpointTest.class);

    @Test
    public void testGW2ApiIsReachable() throws Exception {
        StaticEndpoint staticEndpoint = new StaticEndpoint("https://api.guildwars2.com");
        assertThat(staticEndpoint.isReachable(), is(TRUE));
    }

}
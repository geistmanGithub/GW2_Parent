package GW2JsonDownloader;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Boolean.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GW2ApiTest {

    private final static Logger log = LoggerFactory.getLogger(GW2ApiTest.class);
    private GW2Api gw2Api;
    private String baseURL;
    private String GW2ApiVersion;


    @Before
    public void setUp() throws Exception {
        baseURL = "https://api.guildwars2.com";
        GW2ApiVersion = "v2";
    }

    @Test
    public void testGW2BaseApisAsExpected() throws Exception {
        gw2Api = new GW2Api(baseURL);
        assertThat(gw2Api.isReachable(), is(TRUE));
        assertThat(gw2Api.getContent(), is("[\"v1\",\"v2\"]"));
    }

    @Test
    public void testGW2ApiContinentEndpointIsReachable() throws Exception {
        //TODO: replace with URL to not define URL Buildup logic with strings.
        final String endpoint = "continents";
        final String idsParam = "ids=all";
        final String langParam = "lang=en";
        GW2Api continentsEndpoint = new GW2Api(baseURL + "/" + GW2ApiVersion + "/" + endpoint + "?" + idsParam + "&" + langParam);
        assertThat(continentsEndpoint.isReachable(), is (TRUE));
    }
}
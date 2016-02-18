package GW2JsonDownloader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Boolean.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GW2ApiBaseTest {

    private final static Logger log = LoggerFactory.getLogger(GW2ApiBaseTest.class);
    private GW2ApiBase gw2ApiBase;
    private String baseURL;
    private String GW2ApiVersion;


    @Before
    public void setUp() throws Exception {
        baseURL = "https://api.guildwars2.com";
        gw2ApiBase = new GW2ApiBase(baseURL);
        GW2ApiVersion = "v2";
    }

    @Test
    public void testGW2ApiIsReachable() throws Exception {
        assertThat(gw2ApiBase.isReachable(), is(TRUE));
    }

    @Test
    public void testAPIVersionIsAsExpected() throws Exception {
        assertThat(gw2ApiBase.getVersions(), is("[\"v1\",\"v2\"]"));
    }

    @Test
    public void testGW2ApiContinentEndpointIsReachable() throws Exception {
        //TODO: replace with URL to not define URL Buildup logic with strings.
        final String endpoint = "continents";
        final String idsParam = "ids=all";
        final String langParam = "lang=en";
        GW2ApiBase continentsEndpoint = new GW2ApiBase(baseURL + "/" + GW2ApiVersion + "/" + endpoint + "?" + idsParam + "&" + langParam);
        assertThat(continentsEndpoint.isReachable(), is (TRUE));
    }
}
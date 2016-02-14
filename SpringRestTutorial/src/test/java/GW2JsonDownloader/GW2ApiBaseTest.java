package GW2JsonDownloader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Boolean.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GW2ApiBaseTest {

    private final static Logger log = LoggerFactory.getLogger(GW2ApiBaseTest.class);

    @Test
    public void testGW2ApiIsReachable() throws Exception {
        GW2ApiBase gw2ApiBase = new GW2ApiBase("https://api.guildwars2.com");
        assertThat(gw2ApiBase.isReachable(), is(TRUE));
    }

    @Test
    public void testAPIVersionIsAsExpected() throws Exception {
        GW2ApiBase gw2ApiBase = new GW2ApiBase("https://api.guildwars2.com");
        assertThat(gw2ApiBase.getVersions(), is("[\"v1\",\"v2\"]"));
    }
}
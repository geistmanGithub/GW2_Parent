package SimpleRestClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SimpleRestClientTest {

    private static final Logger log = LoggerFactory.getLogger(SimpleRestClientTest.class);
    private static RestTemplate restTemplate = new RestTemplate();
    private  static final Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/4", Quote.class);

    @org.junit.BeforeClass
    public static void setUp() throws Exception {
    }

    @Test
    public void testQuoteInitialized() throws Exception {
        log.debug("String representation of quote: " + quote.toString());
        assertNotNull(quote.getType());
        assertNotNull(quote.getValue());
    }

    @Test
    public void testQuoteSuccess() throws Exception {
        log.debug("Type: " + quote.getType());
        assertEquals(quote.getType(), "success");
    }

}

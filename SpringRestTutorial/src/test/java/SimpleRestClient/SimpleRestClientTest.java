package SimpleRestClient;

import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


public class SimpleRestClientTest {

    private static final Logger log = LoggerFactory.getLogger(SimpleRestClientTest.class);

    @org.junit.BeforeClass
    public static void setUp() throws Exception {
    }

    @Test
    public void testQuoteSuccess() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        log.info("String representation of quote: " + quote.toString());
        assertNotNull(quote.getType());
        assertNotNull(quote.getValue());

        log.info("Type: " + quote.getType());
        assertEquals(quote.getType(), "success");






    }

}

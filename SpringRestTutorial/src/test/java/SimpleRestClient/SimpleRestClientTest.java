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

    @org.junit.BeforeClass
    public static void setUp() throws Exception {
    }

    @Test
    public void testQuoteSuccess() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        assertNotNull(quote.getType());
        assertNotNull(quote.getValue());
    }
}

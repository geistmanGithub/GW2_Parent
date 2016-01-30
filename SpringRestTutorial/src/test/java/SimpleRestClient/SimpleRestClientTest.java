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

    Quote quote;

    @org.junit.BeforeClass
    public void setUp() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        this.quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

    @Test
    public void testQuoteSuccess() throws Exception {
        assertNotNull(quote.getType());
        assertNotNull(quote.getValue());
    }
}

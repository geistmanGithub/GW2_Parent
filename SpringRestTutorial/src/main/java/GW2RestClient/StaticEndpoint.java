package GW2RestClient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class StaticEndpoint {

    private static final Logger log = LoggerFactory.getLogger(StaticEndpoint.class);
    protected boolean isReachable() {


        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) urlConnection;
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            log.debug("URL:" + url.toExternalForm() + " Response Code:" + responseCode);
            return (200 <= responseCode && responseCode <= 399);

        } catch (IOException e) {
            log.error(e.toString(), e);
            return false;
        }

    }
}

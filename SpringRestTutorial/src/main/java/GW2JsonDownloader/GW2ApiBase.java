package GW2JsonDownloader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;


public class GW2ApiBase {

    private static final Logger log = LoggerFactory.getLogger(GW2ApiBase.class);
    private URL url;


    public GW2ApiBase(String url) {

        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            log.error(e.toString(), e);
        }
    }


    protected boolean isReachable() {
        int responseCode = 0;
        try {
            HttpURLConnection connection = getHttpURLConnection();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            log.error(e.toString(), e);
        }

        log.debug("URL:" + url.toExternalForm() + " Response Code:" + responseCode);
            return (200 <= responseCode && responseCode <= 399);
    }

    private HttpURLConnection getHttpURLConnection() throws IOException{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);
        connection.setRequestMethod("GET");

        return connection;
    }

    protected String getVersions() {
        StringBuilder result = new StringBuilder();
        try {
            HttpURLConnection connection = getHttpURLConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            result.append(reader.readLine());
            reader.close();
            log.debug("Content:" + result.toString());

        } catch (IOException e) {
            log.error(e.toString(), e);
            return null;
        }
        return result.toString();


    }
}

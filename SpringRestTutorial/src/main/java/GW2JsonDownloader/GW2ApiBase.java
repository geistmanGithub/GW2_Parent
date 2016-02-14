package GW2JsonDownloader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class GW2ApiBase {

    private static final Logger log = LoggerFactory.getLogger(GW2ApiBase.class);
    private URL url;
    private HttpURLConnection connection;


    public GW2ApiBase(String url) {

        try {
            this.url = new URL(url);
            openGetConnection();
            connection.disconnect();
        } catch (MalformedURLException e) {
            log.error(e.toString(), e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected boolean isReachable() {
        int responseCode;
        try {
            responseCode = connection.getResponseCode();

            log.debug("URL:" + url.toExternalForm() + " Response Code:" + responseCode);
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException e) {
            log.error(e.toString(), e);
            return false;
        }
    }

    private void openGetConnection() throws IOException{
        connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);
        connection.setRequestMethod("GET");
    }

    protected String getVersions() {
        StringBuilder result = new StringBuilder();
        try {
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

package GW2RestClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class StaticEndpoint {

    protected boolean isReachable() {


        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}

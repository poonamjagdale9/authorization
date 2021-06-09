package HowToCallApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Consent {
    public static void main(String[] args) {

        try {
           // URL url = new URL("https://reqres.in/api/users?page=2");
            URL url = new URL("https://ob.sandbox.rbs.co.uk/token");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); //5 seconds
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println(status);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

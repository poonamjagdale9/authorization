package HowToCallApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CallApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url= "https://ob.sandbox.rbs.co.uk/token";
        //https://reqres.in/api/users?page=2
        //https://ob.sandbox.rbs.co.uk/token
        // create http request
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.statusCode());

    }
}

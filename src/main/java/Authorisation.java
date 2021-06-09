import io.restassured.RestAssured;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Authorisation {
    private RestAssured Unirest;

    @Test
       public void JavaOkhttp () throws IOException {
           OkHttpClient client = new OkHttpClient().newBuilder()
                   .build();
           Request request = new Request.Builder()
                   .url("https://api.sandbox.rbs.co.uk/.well-known/openid-configuration")
                   .method("GET", null)
                   .build();
           Response response = client.newCall(request).execute();
       }

       @Test
       public void accessTokenCall() throws IOException {
           OkHttpClient client = new OkHttpClient().newBuilder()
                   .build();
           MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
           RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=2rZtXET0e7JLyhRB4-J0pS1JQwWAAanxd9A4elAxqQA=&client_secret=T6gjWgsnsTJ1yG_oVUD022dbuGYl_AvEluXabsYX8Jo=&scope=accounts");
           Request request = new Request.Builder()
                   .url("https://ob.sandbox.rbs.co.uk/token")
                   .method("POST", body)
                   .addHeader("Content-Type", "application/x-www-form-urlencoded")
                   .build();
           Response response = client.newCall(request).execute();
       }

}

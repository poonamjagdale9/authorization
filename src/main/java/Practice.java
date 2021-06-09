import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;
public class Practice {
   // @Test
    public void getCall(){
        Response response = given()
                .when().get("https://api.sandbox.rbs.co.uk/.well-known/openid-configuration");
        response.prettyPrint();
        response.then().statusCode(200);
              // .body("keys.kid",hasItems("E8dy_cud7MDjV_1sBSs2dUER1ss")); // assertion
        //.body("keys.kty",hasItems("RSA"));

        int code =response.statusCode();
        Assertions.assertEquals(200,code);

    }
    @Test
    public void postCall() throws NoSuchAlgorithmException, KeyManagementException {

        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {  }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        /*
         * end of the fix
         */
        Response res = given()
                .when().body("grant_type=client_credentials&client_id" +
                        "=2rZtXET0e7JLyhRB4-J0pS1JQwWAAanxd9A4elAxqQA=&client_secret=" +
                        "T6gjWgsnsTJ1yG_oVUD022dbuGYl_AvEluXabsYX8Jo=&scope=accounts").post("https://ob.sandbox.rbs.co.uk/token");
        res.prettyPrint();
        res.then().statusCode(201);

        /*SSLContext sc = SSLContext.getInstance("SSL");
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());*/




       /* SSLContext sc = SSLContext.getInstance("SSL");
        TrustManager[] trustAllCerts = new TrustManager[0];
        sc.init(null, trustAllCerts, new java.security.SecureRandom());*/


        // sc.init(null, trustAllCerts, new java.security.SecureRandom());

        //System.setProperty("com.sun.net.ssl.checkRevocation", "false");

    }}














   /* public void postCall(){
        Response res = given().contentType("Application/json")
                .when().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").post("https://reqres.in/api/users");
        res.prettyPrint();
        res.then().statusCode(201)
                .body("name",is("morpheus"));
        int code = res.statusCode();
        System.out.println("Status code is :" +code);
    }*/




package web_client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public abstract class WebClient implements IWebClient{



    @Override
    public String sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    @Override
    public HttpRequest makeRequest(String path, HttpMethod method, String body, String... headers) {

        return HttpRequest.newBuilder().uri(URI.create(path)).method(method.methodName, HttpRequest.BodyPublishers.ofString(body)).headers(headers).build();
    }



}

interface IWebClient {
    HttpClient httpClient = HttpClient.newBuilder().build();
    String sendRequest(HttpRequest request) throws IOException, InterruptedException;
    HttpRequest makeRequest(String path, HttpMethod method, String body, String... headers);
    enum HttpMethod {
        GET("GET"), POST("POST");
        final String methodName;
        HttpMethod(String methodName) {
            this.methodName = methodName;
        }
    }
}

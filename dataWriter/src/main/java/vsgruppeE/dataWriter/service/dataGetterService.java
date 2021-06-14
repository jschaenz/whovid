package vsgruppeE.dataWriter.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class dataGetterService {
    private JSONObject data;

    private static String DATA_URL = "https://supinic.com/api/data/corona/global/latest";

    public JSONObject getData() throws IOException, InterruptedException {
        HttpClient dataGetter = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();
        HttpResponse<String> response = dataGetter.send(request, HttpResponse.BodyHandlers.ofString());
        this.data = new JSONObject(response.body());
        return this.data;
    }
}

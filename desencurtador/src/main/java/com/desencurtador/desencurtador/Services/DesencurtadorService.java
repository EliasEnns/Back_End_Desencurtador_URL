package com.desencurtador.desencurtador.Services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Service
public class DesencurtadorService {
    private String apiUrl = "https://unshorten.me/api/v2/unshorten?format=json&url=";
    private String apiToken = "Eu sei que vocês querem o token, mas não posso dar, desculpe :(";
    private String shortUrl;
    private String longUrl;

    private List<String> links = new ArrayList<>();

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        try {
            this.longUrl = makeRequest(apiUrl + shortUrl, apiToken);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        links.add(this.longUrl);
        return this.longUrl;
    }

    public List<String> getAllLinks() {
        return links;
    }

                // ...

private String makeRequest(String url, String token) throws URISyntaxException {
    try {
        URL apiUrl = new URI(url).toURL();
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Token " + token);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Log the raw response to inspect its structure
            System.out.println("Response: " + response.toString());

            // Use JsonElement to handle both JsonObject and JsonPrimitive
            JsonElement jsonElement = JsonParser.parseString(response.toString());

            if (jsonElement.isJsonObject()) {
                JsonObject jsonResponse = jsonElement.getAsJsonObject();
                if (jsonResponse.get("success").getAsBoolean()) {
                    return jsonResponse.get("unshortened_url").getAsString();  // Ensure to get it as a string
                } else {
                    System.out.println("Request was not successful.");
                    return null;
                }
            } else if (jsonElement.isJsonPrimitive()) {
                // Handle the case where a primitive (e.g., string) is returned
                return jsonElement.getAsString();
            } else {
                System.out.println("Unexpected JSON structure.");
                return null;
            }
        } else {
            // Handle any errors that occurred during the request
            System.out.println("Request failed with response code: " + responseCode);
            return null;
        }
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

}

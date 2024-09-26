import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Desencurtador {
    private String apiUrl = "https://unshorten.me/api/v2/unshorten?url=";
    private String apiToken = "CENSURADO";
    private String shortUrl;
    private String longUrl;

    // constructor
    public Desencurtador() {
    }

    // method
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        try {
            makeRequest(apiUrl + shortUrl, apiToken);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.longUrl;
    }

    private void makeRequest(String url, String token) throws URISyntaxException {
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

                // Handle the response data here
                this.longUrl = response.toString();
                System.out.println(response);
            } else {
                // Handle any errors that occurred during the request
                System.out.println("Request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

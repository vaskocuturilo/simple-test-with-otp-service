package api;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ServiceHelper {

    public static String getOneTimePassword() throws URISyntaxException {
        final URIBuilder uri = new URIBuilder("http://localhost:8080/");
        uri.setPath("/api/otp");
        final String response = getResponse(uri.toString());
        final JSONObject jsonObj = new JSONObject(response);
        final Object oneTimePassword = jsonObj.get("code");
        return String.valueOf(oneTimePassword);
    }

    private static String getResponse(final String urlToRead) {
        final StringBuilder result = new StringBuilder();
        final URL url;
        try {
            url = new URL(urlToRead);
        } catch (MalformedURLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        final HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        String line;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException exception) {
                throw new RuntimeException(exception.getMessage());
            }
            result.append(line);
        }
        try {
            reader.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return result.toString();
    }
}

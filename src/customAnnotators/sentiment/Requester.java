package customAnnotators.sentiment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class Requester {
    private HttpURLConnection conn = null;

    Requester() {
        try {
            URL url = new URL("http://127.0.0.1:5000/sentimentAnnotator/");
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("charset", "utf-8");
        } catch (IOException e){
            e.printStackTrace();
        }finally
        {
            if(conn != null)
            {
                conn.disconnect();
            }
        }
    }

    JsonObject post_sentiment(String text) throws IOException {
        DataOutputStream os = new DataOutputStream(conn.getOutputStream());
        text = "{\"text\": \""+text+"\"}";
        byte[] postData = text.getBytes(StandardCharsets.UTF_8);
        os.write(postData);
        os.flush();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String response = br.readLine();
        JsonObject jsonResponse = new JsonParser().parse(response).getAsJsonObject();
        conn.disconnect();
        return jsonResponse;

    }
}

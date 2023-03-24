package com.americar.ecommerceapi.security;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class ExternalApiAuthClient {
    private static final long EXPIRATION_TIME = 3600;
    //Aqui se implementa la logica de solicitar el token y almacenarlo en la sesion

    @Value("${tokenUrl}")
    private  String TOKEN_URL;

    @Value("${api-quiter-base}")
    private String API_HOST;

    @Value("${clientId}")
    private  String CLIENT_ID;

    @Value("${clientSecret}")
    private  String CLIENT_SECRET;

    @Value("${grantType}")
    private  String GRANT_TYPE;

    @Value("${code}")
    private  String CODE;

    @Autowired
    private HttpSession httpSession;

    public String getAccessToken() throws IOException {
        String accessToken = (String) httpSession.getAttribute("access_token");
        LocalDateTime tokenTime = (LocalDateTime) httpSession.getAttribute("access_token_time");

        if (accessToken == null || tokenTime == null || tokenTime.plusSeconds(EXPIRATION_TIME).isBefore(LocalDateTime.now())) {
            accessToken = requestNewToken();
            httpSession.setAttribute("access_token", accessToken);
            httpSession.setAttribute("access_token_time", LocalDateTime.now());
        }

        return accessToken;
    }

    private String requestNewToken() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(TOKEN_URL);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        StringEntity stringEntity = new StringEntity(
                "grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + CODE);
        httpPost.setEntity(stringEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(responseString).getAsJsonObject();
        String accessToken = jsonResponse.get("access_token").getAsString();

        return accessToken;
    }



}

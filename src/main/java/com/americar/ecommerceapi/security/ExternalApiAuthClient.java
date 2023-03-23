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
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ExternalApiAuthClient {
    //Aqui se implementa la logica de solicitar el token y almacenarlo en la sesion
    private static final String TOKEN_URL = "https://qis.quiter.com/qis/oauth/token";
    private static final String CLIENT_ID = "samurai";
    private static final String CLIENT_SECRET = "6c4a977e82e0d5a21ac165c00d58d9be5e6ab0d0";
    private static final String GRANT_TYPE = "authorization_code";
    private static final String CODE = "b669850c8c8bb910313359fb8168f76e4bff68c8";

    @Autowired
    private HttpSession httpSession;

    public String getAccessToken() throws IOException {
        String accessToken = (String) httpSession.getAttribute("access_token");

        if (accessToken == null) {
            accessToken = requestNewToken();
            httpSession.setAttribute("access_token", accessToken);
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

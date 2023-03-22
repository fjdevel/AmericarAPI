package com.americar.ecommerceapi.security;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static final String TOKEN_SESSION_KEY = "access_token";

    public String getAccessToken(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(true); // Crea una nueva sesión si no existe
        String token = (String) session.getAttribute(TOKEN_SESSION_KEY);
        if (token == null) {
            token = requestNewToken();
            session.setAttribute(TOKEN_SESSION_KEY, token);
        }
        return token;
    }

    private String requestNewToken() throws Exception {
        JsonParser parser = new JsonParser();
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setSSLContext(getTrustAllSSLContext());
        HttpClient client = clientBuilder.build();

        String token;

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));
        params.add(new BasicNameValuePair("client_id", "samurai"));
        params.add(new BasicNameValuePair("client_secret", "6c4a977e82e0d5a21ac165c00d58d9be5e6ab0d0"));
        params.add(new BasicNameValuePair("code","b669850c8c8bb910313359fb8168f76e4bff68c8"));

        HttpPost post = new HttpPost("https://qis.quiter.com/qis/oauth/token");

        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        post.setEntity(new StringEntity(URLEncodedUtils.format(params, "UTF-8")));
        HttpResponse res = client.execute(post);

        if (res.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            throw new Exception(EntityUtils.toString(res.getEntity()));
        }

        String data = EntityUtils.toString(res.getEntity());
        JsonObject json = parser.parse(data).getAsJsonObject();

        token = json.has("access_token") ? json.get("access_token").getAsString() : null;

        return token;
    }
    private SSLContext getTrustAllSSLContext() throws Exception {
        TrustStrategy trustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        };

        SSLContextBuilder sslContextBuilder = SSLContexts.custom();
        sslContextBuilder.loadTrustMaterial(null, trustStrategy);
        return sslContextBuilder.build();
    }

}

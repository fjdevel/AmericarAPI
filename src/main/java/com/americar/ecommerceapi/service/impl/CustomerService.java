package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.service.ICustomerService;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Service
public class CustomerService implements ICustomerService {

    private final String QIS_URL = "https://qis.quiter.com";
    private final Gson gson;

    public CustomerService(Gson gson) {
        this.gson = gson;
    }
    @Override
    public CustomersResponse getCustomers(String token, String name, String id, String documentId, String address, String phoneNumber) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String requestUrl = QIS_URL + "/qis/api/spareparts/v2"+ "?name=" + URLEncoder.encode(name, StandardCharsets.UTF_8)
                + "&id=" + URLEncoder.encode(id, StandardCharsets.UTF_8)
                + "&documentId=" + URLEncoder.encode(documentId, StandardCharsets.UTF_8)
                + "&address=" + URLEncoder.encode(address, StandardCharsets.UTF_8)
                + "&phoneNumber=" + URLEncoder.encode(phoneNumber, StandardCharsets.UTF_8)
                + "&mobilePhoneNumber=" + URLEncoder.encode(phoneNumber, StandardCharsets.UTF_8);
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, TrustAllStrategy.INSTANCE)
                .build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, (hostname, session) -> true);

        HttpClient client = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        HttpGet request = new HttpGet(requestUrl);
        request.setHeader("Authorization", "Bearer " + token);

        HttpResponse res = client.execute(request);

        if (res.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Error en la respuesta: " + res.getStatusLine().getStatusCode());
        }

        HttpEntity entity = res.getEntity();
        try (InputStream content = entity.getContent()) {
            return gson.fromJson(new InputStreamReader(content, StandardCharsets.UTF_8), CustomersResponse.class);
        }


    }
}

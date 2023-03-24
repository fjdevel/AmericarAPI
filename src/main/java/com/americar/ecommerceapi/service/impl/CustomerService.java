package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.entity.Customer;
import com.americar.ecommerceapi.security.ExternalApiAuthClient;
import com.americar.ecommerceapi.service.ICustomerService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private static final String BASE_URL = "https://qis.quiter.com/qis/api/spareparts/v2";
    @Autowired
    private ExternalApiAuthClient authClient;

    @Override
    public CustomersResponse getCustomers(String name, String id, String documentId, String address, String phoneNumber) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/customers";
        List<String> queryParams = new ArrayList<>();

        if (name != null) {
            queryParams.add("name=" + URLEncoder.encode(name, StandardCharsets.UTF_8));
        }
        if (id != null) {
            queryParams.add("id=" + URLEncoder.encode(id, StandardCharsets.UTF_8));
        }
        if (documentId != null) {
            queryParams.add("documentId=" + URLEncoder.encode(documentId, StandardCharsets.UTF_8));
        }
        if (address != null) {
            queryParams.add("address=" + URLEncoder.encode(address, StandardCharsets.UTF_8));
        }
        if (phoneNumber != null) {
            queryParams.add("phoneNumber=" + URLEncoder.encode(phoneNumber, StandardCharsets.UTF_8));
        }

        if (!queryParams.isEmpty()) {
            requestUrl += "?" + String.join("&", queryParams);
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(responseString).getAsJsonObject();
        JsonArray jsonArray = jsonResponse.getAsJsonArray("customers");

        Gson gson = new Gson();
        List<Customer> customerList = gson.fromJson(jsonArray, new TypeToken<List<Customer>>() {}.getType());
        CustomersResponse response = new CustomersResponse();
        response.setCustomers(customerList);
        return response;
    }

    @Override
    public Customer createCustomer(CustomerCreateDto data) throws IOException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/customers";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setHeader("Authorization", "Bearer " + accessToken);
        httpPost.setHeader("Content-Type", "application/json");

        Gson gson = new Gson();
        String jsonData = gson.toJson(data);
        StringEntity entity = new StringEntity(jsonData, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        JsonObject jsonResponse = gson.fromJson(responseString, JsonObject.class);
        Customer createdCustomer = gson.fromJson(jsonResponse, Customer.class);
        return createdCustomer;
    }
}

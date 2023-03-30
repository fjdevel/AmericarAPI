package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.*;
import com.americar.ecommerceapi.entity.Part;
import com.americar.ecommerceapi.entity.Vehicle;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpStatus;
import com.americar.ecommerceapi.security.ExternalApiAuthClient;
import com.americar.ecommerceapi.service.IPartReturnService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PartReturnService implements IPartReturnService{

    @Value("${api-quiter-base}")
    private String BASE_URL;
    @Autowired
    private ExternalApiAuthClient authClient;


    @Override
    public ApiResponse<PartsResponseDto> searchParts(Map<String, String> queryParams) throws IOException, URISyntaxException {
        String accessToken = authClient.getAccessToken();
        String requestUrl = BASE_URL + "/parts";

        URIBuilder uriBuilder = new URIBuilder(requestUrl);
        for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
            uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
        }
        URI uri = uriBuilder.build();
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<PartsResponseDto> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            JsonObject jsonResponse = gson.fromJson(responseString, JsonObject.class);
            JsonArray jsonParts = jsonResponse.getAsJsonArray("parts");
            Type listType = new TypeToken<List<Part>>() {}.getType();
            List<Part> partDtoList = gson.fromJson(jsonParts, listType);
            PartsResponseDto partsResponseDto = new PartsResponseDto();
            partsResponseDto.setParts(partDtoList);
            apiResponse.setData(partsResponseDto);
        } else {
            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

    @Override
    public ApiResponse<VehiclesResponseDto> searchVehicles(Map<String, String> queryParams) throws IOException {
        String accessToken = authClient.getAccessToken();
        String requestUrl = BASE_URL + "/vehicles";

        // Agrega los parámetros de consulta a la URL
        if (!queryParams.isEmpty()) {
            requestUrl += "?";
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                requestUrl += entry.getKey() + "=" + entry.getValue() + "&";
            }
            requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);
        Gson gson = new Gson();

        ApiResponse<VehiclesResponseDto> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            JsonObject jsonResponse = gson.fromJson(responseString, JsonObject.class);
            VehiclesResponseDto response = gson.fromJson(jsonResponse, VehiclesResponseDto.class);
            apiResponse.setData(response);
        } else {
            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

    @Override
    public ApiResponse<Vehicle> getVehicleById(String id) throws IOException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/vehicles/" + id;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<Vehicle> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            Gson gson = new Gson();
            Vehicle response = gson.fromJson(responseString, Vehicle.class);
            apiResponse.setData(response);
        } else {
            Gson gson = new Gson();

            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

    @Override
    public ApiResponse<Part> getPartById(String id) throws IOException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/parts/" + id;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<Part> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            Gson gson = new Gson();
            Part response = gson.fromJson(responseString, Part.class);
            apiResponse.setData(response);
        } else {
            Gson gson = new Gson();
            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

    @Override
    public ApiResponse<PartsResponseDto> searchParts(String id, String description, String family, String entryDate, String brand) throws IOException, URISyntaxException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/parts";
        URIBuilder uriBuilder = new URIBuilder(requestUrl);
        if (id != null) uriBuilder.addParameter("id", id);
        if (description != null) uriBuilder.addParameter("description", description);
        if (family != null) uriBuilder.addParameter("family", family);
        if (entryDate != null) uriBuilder.addParameter("entryDate", entryDate);
        if (brand != null) uriBuilder.addParameter("brand", brand);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<PartsResponseDto> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            Gson gson = new Gson();
            PartsResponseDto response = gson.fromJson(responseString, PartsResponseDto.class);
            apiResponse.setData(response);
        } else {
            Gson gson = new Gson();

            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

    @Override
    public ApiResponse<PartsResponseDto> searchOemParts(String id, String description, String family, String entryDate, String brand) throws IOException, URISyntaxException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/partsoem";
        URIBuilder uriBuilder = new URIBuilder(requestUrl);
        if (id != null) uriBuilder.addParameter("id", id);
        if (description != null) uriBuilder.addParameter("description", description);
        if (family != null) uriBuilder.addParameter("family", family);
        if (entryDate != null) uriBuilder.addParameter("entryDate", entryDate);
        if (brand != null) uriBuilder.addParameter("brand", brand);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<PartsResponseDto> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            Gson gson = new Gson();
            PartsResponseDto response = gson.fromJson(responseString, PartsResponseDto.class);
            apiResponse.setData(response);
        } else {
            Gson gson = new Gson();

            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

}

package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartReturnTypesResponseDto;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.security.ExternalApiAuthClient;
import com.americar.ecommerceapi.service.IPartReturnTypeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class PartReturnTypeService implements IPartReturnTypeService{
    @Value("${api-quiter-base}")
    private String BASE_URL;
    @Autowired
    private ExternalApiAuthClient authClient;

    @Override
    public ApiResponse<PartReturnTypesResponseDto> getPartReturnTypes() throws IOException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/partsReturnTypes";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        httpGet.setHeader("Content-Type", "application/json");
        Gson gson = new Gson();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<PartReturnTypesResponseDto> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            JsonObject jsonResponse = gson.fromJson(responseString, JsonObject.class);
            PartReturnTypesResponseDto response = gson.fromJson(jsonResponse, PartReturnTypesResponseDto.class);
            apiResponse.setData(response);
        } else {
            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }
}

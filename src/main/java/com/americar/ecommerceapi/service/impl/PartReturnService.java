package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.exception.ApiResponse;
import org.apache.http.HttpStatus;
import com.americar.ecommerceapi.security.ExternalApiAuthClient;
import com.americar.ecommerceapi.service.IPartReturnService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class PartReturnService implements IPartReturnService {

    @Value("${api-quiter-base}")
    private String BASE_URL;
    @Autowired
    private ExternalApiAuthClient authClient;

    @Override
    public ApiResponse<PartReturnCreateResponseDto> createPartReturn(PartReturnCreateDto partReturnCreateDto) throws IOException {
        String accessToken = authClient.getAccessToken();

        String requestUrl = BASE_URL + "/partsReturn";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setHeader("Authorization", "Bearer " + accessToken);
        httpPost.setHeader("Content-Type", "application/json");

        Gson gson = new Gson();
        String jsonData = gson.toJson(partReturnCreateDto);
        StringEntity entity = new StringEntity(jsonData, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntity);

        ApiResponse<PartReturnCreateResponseDto> apiResponse = new ApiResponse<>();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        apiResponse.setStatusCode(statusCode);

        if (statusCode == HttpStatus.SC_OK) {
            JsonObject jsonResponse = gson.fromJson(responseString, JsonObject.class);
            PartReturnCreateResponseDto response = gson.fromJson(jsonResponse, PartReturnCreateResponseDto.class);
            apiResponse.setData(response);
        } else {
            ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
            apiResponse.setError(errorDto);
        }

        return apiResponse;
    }

}

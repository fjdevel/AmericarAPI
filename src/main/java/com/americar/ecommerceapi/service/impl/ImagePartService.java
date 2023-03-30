package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.entity.ImagePart;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.repository.IImagePartRepository;
import com.americar.ecommerceapi.security.ExternalApiAuthClient;
import com.americar.ecommerceapi.service.IImagePartService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ImagePartService implements IImagePartService {

 @Value("${api-quiter-base}")
 private String BASE_URL;
 @Autowired
 private ExternalApiAuthClient authClient;
 @Override
 public ApiResponse<List<ImagePart>> getImagePartsById(String id) throws IOException {
  String accessToken = authClient.getAccessToken();

  String requestUrl = BASE_URL + "/imagesParts?id=" + id;

  CloseableHttpClient httpClient = HttpClients.createDefault();
  HttpGet httpGet = new HttpGet(requestUrl);
  httpGet.setHeader("Authorization", "Bearer " + accessToken);
  httpGet.setHeader("Content-Type", "application/json");

  HttpResponse httpResponse = httpClient.execute(httpGet);
  HttpEntity httpEntity = httpResponse.getEntity();
  String responseString = EntityUtils.toString(httpEntity);

  ApiResponse<List<ImagePart>> apiResponse = new ApiResponse<>();
  int statusCode = httpResponse.getStatusLine().getStatusCode();
  apiResponse.setStatusCode(statusCode);

  if (statusCode == HttpStatus.SC_OK) {
   Gson gson = new Gson();
   Type listType = new TypeToken<List<ImagePart>>(){}.getType();
   List<ImagePart> response = gson.fromJson(responseString, listType);
   apiResponse.setData(response);
  } else {
   Gson gson = new Gson();

   ErrorDto errorDto = gson.fromJson(responseString, ErrorDto.class);
   apiResponse.setError(errorDto);
  }

  return apiResponse;

 }
}

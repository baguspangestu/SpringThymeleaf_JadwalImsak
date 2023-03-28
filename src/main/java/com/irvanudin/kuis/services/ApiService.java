package com.irvanudin.kuis.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getProvinsi() {
        String url = "https://equran.id/api/v2/imsakiyah/provinsi";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
    
    public String getKabKota(String provinsi) {
      String url = "https://equran.id/api/v2/imsakiyah/kabkota";
      Map<String, String> requestBody = new HashMap<>();
      requestBody.put("provinsi", provinsi);
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
      ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
      return response.getBody();
    }

    public String getJadwal(String provinsi, String kabKota) {
      String url = "https://equran.id/api/v2/imsakiyah/jadwal";
      Map<String, String> requestBody = new HashMap<>();
      requestBody.put("provinsi", provinsi);
      requestBody.put("kabKota", kabKota);
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
      ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
      return response.getBody();
    }
}

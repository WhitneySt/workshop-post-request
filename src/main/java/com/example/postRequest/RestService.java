package com.example.postRequest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Object createPost(String url, Map<String, Object> params) {
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a map for post parameters
        /*
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1);
        map.put("title", "Introduction to Spring Boot");
        map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");
        */

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(params, headers);

        // send POST request
        ResponseEntity<Object> response = this.restTemplate.postForEntity(url, entity, Object.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
